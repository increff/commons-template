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

package com.nextscm.commons.template;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.nextscm.commons.template.form.Address;
import com.nextscm.commons.template.form.PackingListForm;
import com.nextscm.commons.template.form.PackingListLineItem;
import com.nextscm.commons.template.util.FopUtil;
import com.nextscm.commons.template.util.Utils;
import com.nextscm.commons.template.util.VelocityUtil;

public class PackingListIT extends AbstractTest {

	@Test
	public void testPackingList() throws IOException, TransformerException, URISyntaxException, SAXException {
		String fopTemplate = VelocityUtil.processVm(form(), Resources.PACKING_LIST_RESOURCE);
		FileOutputStream fos = new FileOutputStream("target/test-packing2-list.pdf");
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), fos);
	}

	public static PackingListForm form() {
		PackingListForm form = new PackingListForm();
		form.setBoxId("1234567890");
		form.setOrderNo("1983");
		form.setChannelOrderId("POT-410");
		form.setOrderTime(getDate());
		form.setPackingTime(getDate());
		form.setVendorName("BSLPL & Co.");
		form.setTotalQuantity(10000);
		Address vendorAddress = new Address();
		vendorAddress.setCity("Bangalore");
		List<PackingListLineItem> lineItems = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			PackingListLineItem item = new PackingListLineItem();
			item.setItemName("HIGHLANDER FORMAL ~SHIRT");
			item.setMrp(999.4567);
			item.setQuantity(i);
			item.setVendorSku("vendorsku&1234567890");
			lineItems.add(item);
		}
		form.setLineItems(lineItems);
		return form;
	}



}
