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

import com.increff.commons.template.form.*;
import com.increff.commons.template.util.FopUtil;
import com.increff.commons.template.util.Utils;
import com.increff.commons.template.util.VelocityUtil;
import com.increff.commons.template.form.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CancelledInvoiceIT extends AbstractTest {

	@Test
	public void testInvoice() throws IOException, TransformerException, URISyntaxException, SAXException {
		String fopTemplate = VelocityUtil.processVm(form(), Resources.INVOICE_RESOURCE);
		FileOutputStream fos = new FileOutputStream("target/test-cancelled-invoice.pdf");
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), fos);
	}


	public static InvoiceForm form() {
		InvoiceForm form = new InvoiceForm();
		Address billingAddress = getAddress("Romil & Jain");
		billingAddress.setLine1(null); // Purposefully doing this to test
		form.setBillingAddress(billingAddress);
		form.setChannelName("Myntra & Co...");
		form.setChannelOrderNo("Myntra & 123456");
		form.setFromAddress(getAddress("WhiteField Warehouse"));
		form.setFromTaxId("FROM & 1234567890");
		form.setInvoiceOrStockTransferNo("Invoice/12345\u002690");
		form.setInvoiceOrStockTransferTime(new Date());
		List<InvoiceLineItem> lineItems = getLineItems(20);
		form.setItemLines(lineItems);
		form.setOrderNo("Order/12345\u00267890");
		form.setOrderTime(getDate());
		form.setShippingAddress(getAddress("Rajul Jain"));
		form.setToTaxId("TO & 1234567890");
		form.setSignatureUrl("https://camo.githubusercontent.com/805e05b94844e39d7edd518f492c8599c71835b3/687474703a2f2f692e696d6775722e636f6d2f646e5873344e442e706e67");
		form.setVendorName("BSLPL & Sons");
		form.setCurrency("INR");
		form.setInvoiceCancelled(true);
		//form.setPanNo("BFPPG7345N");
        /*form.setRemarks("Notes/ Disclaimer: &#8224;" +
                "\n" +
                "1.       Payment Terms/ Credit Days: This invoice is due for payment with credit period of 60 days as per terms of contract." +
                "\n" +
                "2.       Freight/ Transportation Terms: To be borne by us as per terms of contract." +
                "\n" +
                "3.       Delivery Terms: As per terms of contracts." +
                "\n" +
                "4.       Product Returns/Effect of remedies/Product Recall Terms: As per terms of contract." +
                "\n" +
                "5.       Insurance Terms: As per terms of contract." +
                "\n" +
                "6.       Please pay through cheque/NEFT/RTGS/Via Transfer drawn in favor of MOJOSTAR BRAND MANAGEMENT  MERCHANDISINGSOLUTIONS PVT LTD ");
*/
		double finalBaseValue = 0;
		double finalTaxAmount = 0;
		double finalTotalAmount = 0;

		double subBaseValue = 0;
		double subTaxAmount = 0;
		double subTotalAmount = 0;

		int totalQuantity = 0;
		for (InvoiceLineItem item : lineItems) {
			totalQuantity += item.getQuantity();

			subBaseValue += item.getBaseSellingPriceTotal();
			subTotalAmount += item.getActualSellingPriceTotal();
			subTaxAmount += item.getNetTaxAmountTotal();

			finalBaseValue += item.getBaseSellingPriceTotal();
			finalTotalAmount += item.getActualSellingPriceTotal();
			finalTaxAmount += item.getNetTaxAmountTotal();
		}

		List<ServiceLineItem> serviceItems = getServiceLineItems();
		form.setServiceLines(serviceItems);
		for (ServiceLineItem item : serviceItems) {
			finalTotalAmount += item.getTotalAmount();
			finalTaxAmount += item.getTaxAmount();
		}

		form.setSubBaseAmount(subBaseValue);
		form.setSubTaxAmount(subTaxAmount);
		form.setSubTotalAmount(subTotalAmount);

		form.setFinalTotalAmount(finalTotalAmount);
		form.setFinalBaseAmount(finalBaseValue);
		form.setQuantity(totalQuantity);
		form.setFinalTaxAmount(finalTaxAmount);

		form.setFromPartyName("BSLPL");
		form.setToPartyName("Myntra Designs Pvt. Ltd.");

		return form;
	}

	public static List<InvoiceLineItem> getLineItems(int count) {
		List<InvoiceLineItem> list = new ArrayList<>();
		for (int i = 1; i < count + 1; i++) {
			InvoiceLineItem item = new InvoiceLineItem();
			item.setBaseSellingPricePerUnit(399.123);
			item.setChannelSku("channelSku & " + i);
			item.setHsnId("HSN & " + i);
			item.setItemName("Item Name _~!@#$%^&*();<> " + i);
			item.setMrp(699.123);
			item.setQuantity(i);
			item.setVendorSku("Vendor SKU & " + i);
			item.setBaseSellingPriceTotal(item.getQuantity() * item.getBaseSellingPricePerUnit());
			item.setNetTaxAmountTotal(item.getBaseSellingPriceTotal() * 10 / 100);
			item.setActualSellingPriceTotal(item.getBaseSellingPriceTotal() + item.getNetTaxAmountTotal());
			item.setSubTaxItemData(getTaxRates());
			list.add(item);
		}
		return list;
	}

	public static List<TaxRateLineItem> getTaxRates() {
		List<TaxRateLineItem> list = new ArrayList<>();
		TaxRateLineItem item1 = new TaxRateLineItem("CGST%", 1.124);
		TaxRateLineItem item2 = new TaxRateLineItem("SGST%", 2.123);
		TaxRateLineItem item3 = new TaxRateLineItem("IGST%", 3.124);
		TaxRateLineItem item4 = new TaxRateLineItem("CESS%", 0.000);
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		return list;
	}

	public static List<ServiceLineItem> getServiceLineItems() {
		List<ServiceLineItem> list = new ArrayList<>();
		ServiceLineItem item1 = getServiceLineItem("Shipping charge", 30.124, 3, 33.123);
		ServiceLineItem item2 = getServiceLineItem("COD charge", 10.124, 1, 11.123);
		ServiceLineItem item3 = getServiceLineItem("Gift wrapping charge", 5.123, 1, 6.123);
		list.add(item1);
		list.add(item2);
		list.add(item3);
		return list;
	}

	public static ServiceLineItem getServiceLineItem(String name, double bp, double taxAmount, double totalAmount) {
		ServiceLineItem item = new ServiceLineItem();
		item.setBasePrice(bp);
		item.setItemName(name);
		item.setTaxAmount(taxAmount);
		item.setTotalAmount(totalAmount);
		return item;
	}

	public static Address getAddress(String name) {
		Address address = new Address();
		address.setCity("Bangalore_1");
		address.setCountry("India");
		address.setLine1("C2-1502, L&T South City");
		address.setLine2("Arakere, Bannerghatta Road");
		address.setName(name);
		address.setPhone("+91-9900093090");
		address.setState("Karanataka");
		address.setEmail("manish.kumar@nextscm.com");
		address.setZip("560102");
		return address;
	}

}
