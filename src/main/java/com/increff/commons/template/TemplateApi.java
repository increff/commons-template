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

package com.increff.commons.template;

import java.io.OutputStream;
import java.util.TimeZone;

import com.increff.commons.template.util.FopUtil;
import com.increff.commons.template.util.Utils;
import com.increff.commons.template.util.VelocityUtil;

public class TemplateApi {

	public static void setTimezone(String timeZoneStr) {
		Object timeZone = TimeZone.getTimeZone(timeZoneStr);
		assert timeZone != null;
		VelocityUtil.setTimezone(timeZoneStr);
	}

	// E.g. getPdfFromVm(Resources.MANIFEST_RESOURCE, form, os)
	public static <T> void getPdfFromVm(String templateResource, T form, OutputStream os) {
		try {
			String fopTemplate = VelocityUtil.processVm(form, templateResource);
			FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), os);
		} catch (Exception e) {
			throw new TemplateException(e);
		}
	}

	public static <T> void getPdfFromVm(String templateResource, T form, OutputStream os, String timeZoneStr) {
		setTimezone(timeZoneStr);
		getPdfFromVm(templateResource, form, os);
	}

	public static <T> void getPdfFromString(String templateString, T form, OutputStream os) {
		String fopTemplate = VelocityUtil.processString(form, templateString);
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), os);
		
	}

}
