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

package com.increff.commons.template.util;

import com.increff.commons.template.Resources;
import com.increff.commons.template.util.FopResourceResolver;

import org.apache.fop.apps.*;
import org.apache.fop.apps.io.ResourceResolverFactory;
import org.apache.fop.configuration.Configuration;
import org.apache.fop.configuration.ConfigurationException;
import org.apache.fop.configuration.DefaultConfigurationBuilder;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;


public class FopUtil {

	private static final URI DEFAULT_BASE_URI = new File(".").toURI();

	public static void convertToPDF(InputStream dataIs, InputStream formatIs, OutputStream out)
            throws TransformerException, SAXException, IOException, ConfigurationException {

		FopFactoryBuilder fopBuilder = new FopFactoryBuilder(DEFAULT_BASE_URI, new FopResourceResolver());
		fopBuilder.setConfiguration(getFopConfiguration());
		FopFactory fopFactory = fopBuilder.build();
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

		// Construct fop with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

		// Setup XSLT
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(formatIs));

		// Resulting SAX events (the generated FO) must be piped through to
		// FOP
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		// That's where the XML is first transformed to XSL-FO and then
		// PDF is created
		transformer.transform(new StreamSource(dataIs), res);
	}

	private static Configuration getFopConfiguration() throws ConfigurationException {
		DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
		return cfgBuilder.build(Resources.getResource(Resources.FOP_XCONF_RESOURCE));
	}
}