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

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import com.increff.commons.template.PackingListIT;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.runtime.parser.ParseException;
import org.junit.jupiter.api.Test;

import com.increff.commons.template.Resources;
import com.increff.commons.template.form.PackingListForm;

public class VelocityUtilTest {

	@Test
	public void processVm() throws IOException {
		String fopTemplate = VelocityUtil.processVm(PackingListIT.form(), Resources.PACKING_LIST_RESOURCE);
		assertNotNull(fopTemplate);
	}

	@Test
	public void processString() throws IOException, ParseException {
		PackingListForm invoiceForm = PackingListIT.form();
		InputStream is = Resources.getResource(Resources.PACKING_LIST_RESOURCE);
		assertNotNull(is);
		String invoiceTemplate = IOUtils.toString(is, "UTF-8");
		String invoice = VelocityUtil.processString(invoiceForm, invoiceTemplate);
		assertNotNull(invoice);
	}
}
