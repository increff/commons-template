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

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.transform.TransformerException;

import com.increff.commons.template.form.*;
import com.increff.commons.template.util.FopUtil;
import com.increff.commons.template.util.Utils;
import com.increff.commons.template.util.VelocityUtil;
import org.junit.Test;
import org.xml.sax.SAXException;

public class HandoverIT extends AbstractTest{

	@Test
	public void testManifest() throws IOException, TransformerException, URISyntaxException, SAXException {
		HandoverForm handoverForm = form();
		handoverForm.getLineItems().sort(new Comparator<HandoverLineItem>() {
			@Override
			public int compare(HandoverLineItem o1, HandoverLineItem o2) {
				return o2.getBoxCount() - o1.getBoxCount();
			}
		});
		String fopTemplate = VelocityUtil.processVm(handoverForm, Resources.HANDOVER_RESOURCE);
		FileOutputStream fos = new FileOutputStream("target/test-handover.pdf");
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), fos);
	}

	public static HandoverForm form() {
		HandoverForm form = new HandoverForm();
		form.setTransporter("Delhivery & Sons");
		form.setHandoverId("ho1234");
		form.setManifestId("mani1234");
		form.setClientName("Client Name 123456789 123456789 123456789 123456789 123456789 123456789 123456789");
		form.setHandoverTime(getDate());
		form.setChannelId("Amazon_SF");
		form.setChannelManifestId("AMZ_12345");
		Address vendorAddress = new Address();
		vendorAddress.setCity("Bangalore");
		form.setVendorAddress(vendorAddress);
		List<HandoverLineItem> HandoverLineItem = new ArrayList<>();
		int totalBoxCount = 0;
		for (int i = 0; i < 5; i++) {
			HandoverLineItem item = new HandoverLineItem();
			item.setAwbNo("1234567890awbNo&" + i);
//			item.setChannelOrderNo("1234567890 Channel & " + i);
			List<String> itemNames = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {
				itemNames.add("itemName &!@#$%^&*()_+<> " + j);
			}
			item.setItemNames(itemNames);
			item.setOrderNo("1234567890 order & " + i);
//			item.setQuantity(i);
//			item.setToPhone("+91990093090" + i);
//			item.setToZip("560102" + i);
			item.setBoxCount((i+1)*2);
			totalBoxCount += item.getBoxCount();
			HandoverLineItem.add(item);
		}
		form.setTotalBoxCount(totalBoxCount);
		form.setLineItems(HandoverLineItem);
		return form;
	}

}
