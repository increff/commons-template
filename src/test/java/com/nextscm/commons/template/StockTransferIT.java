
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

import com.nextscm.commons.template.form.*;
import com.nextscm.commons.template.util.FopUtil;
import com.nextscm.commons.template.util.Utils;
import com.nextscm.commons.template.util.VelocityUtil;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockTransferIT extends AbstractTest {

	@Test
	public void testStockTransferForSameGstin() throws IOException, TransformerException,  SAXException {
		String fopTemplate = VelocityUtil.processVm(form(), Resources.STOCK_TRANSFER_RESOURCE);
		FileOutputStream fos = new FileOutputStream("target/test-stock-transfer.pdf");
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), fos);
	}


	public static InvoiceForm form() {
		InvoiceForm form = new InvoiceForm();
		form.setChannelName("PAYTM ##!!@* & ;'");
		form.setChannelOrderNo("12378+*&& xyz");
		form.setFromPartyName("WMS4598* ^^''");
		form.setInvoiceOrStockTransferNo("STN ---- : 2345678>\"");
		form.setInvoiceOrStockTransferTime(new Date());
		form.setOrderNo("890");
		form.setOrderTime(new Date());
		form.setPanNo("8967XYZ");
		form.setFromAddress(getAddress("WAREHOUSE XYZ 89'57!!!"));
		form.setShippingAddress(getAddress("TEST WAREHOUSE-78*** &"));
		form.setSignatureUrl("");
		form.setToPartyName("CLIENT3456 @@@ ** %%%\"");

		form.setFromTaxId("123^%ABc");
		form.setToTaxId("123^%ABc");

		form.setCurrency("INR");
		form.setVendorName("VENDOR & XYZ");
		form.setItemLines(getStockTransferLineItems(5));
		form.setQuantity(form.getItemLines().stream().mapToInt(InvoiceLineItem::getQuantity).sum());
		form.setSubTotalAmount(form.getItemLines().stream().mapToDouble(InvoiceLineItem::getActualSellingPriceTotal).sum());
		return form;
	}

	public static List<InvoiceLineItem> getStockTransferLineItems(int count) {
		List<InvoiceLineItem> list = new ArrayList<>();
		for (int i = 1; i < count + 1; i++) {
			InvoiceLineItem item = new InvoiceLineItem();
			item.setChannelSku("channelSku & " + i);
			item.setHsnId("HSN & " + i);
			item.setItemName("Item Name %^&*();<>~!@#$ " + i);
			item.setMrp(699.123);
			item.setQuantity(i);
			item.setVendorSku("Vendor SKU & \"" + i);
			item.setBaseSellingPricePerUnit(6789.099);
			item.setBaseSellingPriceTotal(item.getQuantity() * item.getBaseSellingPricePerUnit());
			item.setActualSellingPriceTotal(item.getBaseSellingPriceTotal());
			list.add(item);
		}
		return list;
	}

	public static Address getAddress(String name) {
		Address address = new Address();
		address.setCity("Bangalore");
		address.setCountry("India");
		address.setLine1("27th MAIN");
		address.setLine2("HSR LAYOUT");
		address.setName(name);
		address.setPhone("+91-9999999999");
		address.setState("Karanataka");
		address.setEmail("test@nextscm.com");
		address.setZip("560000");
		return address;
	}

}

