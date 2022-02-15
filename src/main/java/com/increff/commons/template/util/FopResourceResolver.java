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

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import org.apache.fop.apps.io.ResourceResolverFactory;
import org.apache.xmlgraphics.io.Resource;
import org.apache.xmlgraphics.io.ResourceResolver;

public class FopResourceResolver implements ResourceResolver {

	private final ResourceResolver wrapped;

	public FopResourceResolver() {
		this.wrapped = ResourceResolverFactory.createDefaultResourceResolver();
	}

	@Override
	public Resource getResource(URI uri) throws IOException {
		if (uri.getScheme().equals("classpath")) {
			URL url = getClass().getClassLoader().getResource(uri.getSchemeSpecificPart());
			return new Resource(url.openStream());
		} else {
			return wrapped.getResource(uri);
		}
	}

	@Override
	public OutputStream getOutputStream(URI uri) throws IOException {
		return wrapped.getOutputStream(uri);
	}

}