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

import javax.xml.transform.TransformerException;

import com.increff.commons.template.util.FopUtil;
import com.increff.commons.template.util.Utils;
import com.increff.commons.template.util.VelocityUtil;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.increff.commons.template.form.Address;
import com.increff.commons.template.form.ShippingLabelForm;

public class ShippingLabelIT extends AbstractTest {

	@Test
	public void testPackingList() throws IOException, TransformerException, URISyntaxException, SAXException {
		String fopTemplate = VelocityUtil.processVm(form(), Resources.SHIPPING_LABEL_RESOURCE);
		FileOutputStream fos = new FileOutputStream("target/test-shipping-label.pdf");
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), fos);
	}

	public static ShippingLabelForm form() {
		ShippingLabelForm form = new ShippingLabelForm();
		
		form.setGstin("GSTIN1234");
		form.setInvoiceNo("Invoice1234");
		form.setCodAmount(203.33);
		form.setTitle("LIMEROAD SHIPMENT");
		form.setAwbNo("AWB1234567890&");
		form.setCodAmount(290.12);
		form.setTransporterName("Aramex");

		Address customerAddress = new Address();
		customerAddress.setCity("Bangalore");
		customerAddress.setCountry("India");
		customerAddress.setEmail("romil.jain@gmail.com");
		customerAddress.setLine1("C2 1502, L&T South City, Arakere");
		customerAddress.setLine2("Bannerghatta Road");
		customerAddress.setName("Romil Jain");
		customerAddress.setPhone("9900093090");
		customerAddress.setState("Karanataka");
		customerAddress.setZip("560076");
		form.setToAddress(customerAddress);

		form.setOrderNo("Order1234&");

		Address returnAddress = new Address();
		returnAddress.setCity("Bangalore");
		returnAddress.setCountry("India");
		returnAddress.setEmail("returns@nextscm.com.com");
		returnAddress.setLine1("Our warehouse");
		returnAddress.setLine2("Kolarul");
		returnAddress.setName("Warehouse Operator");
		returnAddress.setPhone("9900093090");
		returnAddress.setState("Karanataka");
		returnAddress.setZip("560102");
		form.setReturnAddress(returnAddress);
		return form;

	}

}
