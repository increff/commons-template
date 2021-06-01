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
import com.nextscm.commons.template.form.ManifestForm;
import com.nextscm.commons.template.form.ManifestLineItem;
import com.nextscm.commons.template.util.FopUtil;
import com.nextscm.commons.template.util.Utils;
import com.nextscm.commons.template.util.VelocityUtil;

public class ManifestIT extends AbstractTest{

	@Test
	public void testManifest() throws IOException, TransformerException, URISyntaxException, SAXException {
		String fopTemplate = VelocityUtil.processVm(form(), Resources.MANIFEST_RESOURCE);
		FileOutputStream fos = new FileOutputStream("target/test-manifest.pdf");
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), fos);
	}

	public static ManifestForm form() {
		ManifestForm form = new ManifestForm();
		form.setTransporter("Delhivery & Sons");
		form.setManifestId("121212121&&");
		form.setVendorName("BSPL & Co.");
		form.setManifestTime(getDate());
		form.setChannelId("Amazon");
		form.setChannelManifestId("AZ123456");
		Address vendorAddress = new Address();
		vendorAddress.setCity("Bangalore");
		List<ManifestLineItem> manifestLineItem = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			ManifestLineItem item = new ManifestLineItem();
			item.setAwbNo("1234567890awbNo&" + i);
			item.setChannelOrderNo("1234567890 Channel & " + i);
			List<String> itemNames = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {
				itemNames.add("itemName &!@#$%^&*()_+<> " + j);
			}
			item.setOrderNo("1234567890 order & " + i);
			item.setQuantity(i);
			item.setToZip("560102" + i);
			manifestLineItem.add(item);
		}
		form.setLineItems(manifestLineItem);
		form.setCurrency("INR");
		return form;
	}

}
