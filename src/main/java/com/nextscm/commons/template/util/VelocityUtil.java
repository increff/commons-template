/*
 * Copyright (c) 2021. Increff
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.nextscm.commons.template.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.MathTool;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class VelocityUtil {

	private static final String CONTEXT = "data";
	private static VelocityEngine engine;
	private static String timeZoneName = "GMT";

	static {
		engine = new VelocityEngine();
		engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
		engine.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
		engine.init();
	}

	public static void setTimezone(String timeZoneStr) {
		timeZoneName = timeZoneStr;
	}

	public static <T> String processString(T data, String templateString) throws ParseException {
		StringReader reader = new StringReader(templateString);
		Template template = getTemplate(reader);
		return process(data, template);
	}

	public static <T> String processVm(T data, String templateVm) {
		Template template = engine.getTemplate(templateVm);
		return process(data, template);
	}

	protected static <T> String process(T data, Template template) {
		VelocityContext context = new VelocityContext();
		context.put(CONTEXT, data);
		Map<String, String> config = new HashMap<>();
		config.put(DateTool.TIMEZONE_KEY, timeZoneName);
		DateTool dateTool = new DateTool();
		dateTool.configure(config);
		context.put("date", dateTool);
		context.put("math", new MathTool());
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		return writer.toString();
	}

	protected static Template getTemplate(StringReader reader) throws ParseException {
		RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
		SimpleNode node = runtimeServices.parse(reader, "Template name");
		Template template = new Template();
		template.setRuntimeServices(runtimeServices);
		template.setData(node);
		template.initDocument();
		return template;
	}

}