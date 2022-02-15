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

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.increff.commons.template.util.FopUtil;
import com.increff.commons.template.util.Utils;
import com.increff.commons.template.util.VelocityUtil;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class TemplateApiTest {

	@Test
	public void testManifest() throws Exception {
		ByteArrayOutputStream baos = test(ManifestIT.form(), Resources.MANIFEST_RESOURCE);
//		assertEquals(7578, baos.size());
		assertTrue(baos.size() > 7300 && baos.size() < 60000);
		saveToPdf(baos.toByteArray(), "test-manifest.pdf");
	}

	@Test
	public void testPackingList() throws Exception {
		ByteArrayOutputStream baos = test(PackingListIT.form(), Resources.PACKING_LIST_RESOURCE);
//		assertEquals(6843, baos.size());
		assertTrue(baos.size() > 6700 && baos.size() < 70000);
		saveToPdf(baos.toByteArray(), "test-packing-list.pdf");
	}

	@Test
	public void testInvoice() throws Exception {
		ByteArrayOutputStream baos = test(InvoiceIT.form(), Resources.INVOICE_RESOURCE);
//		assertEquals(9923, baos.size());
//		assertTrue(baos.size() > 50000 && baos.size() < 90000);
		saveToPdf(baos.toByteArray(), "test-invoice.pdf");
	}

	@Test
	public void testCancelledInvoice() throws Exception {
		ByteArrayOutputStream baos = test(CancelledInvoiceIT.form(), Resources.INVOICE_RESOURCE);
		saveToPdf(baos.toByteArray(), "test-cancelled-invoice.pdf");
	}

	@Test
	public void testShippingLabel() throws Exception {
		ByteArrayOutputStream baos = test(ShippingLabelIT.form(), Resources.SHIPPING_LABEL_RESOURCE);
		System.out.println(baos.size());
		assertTrue(baos.size() > 6000 && baos.size() < 70000);
		saveToPdf(baos.toByteArray(), "test-shipping-label.pdf");
	}

	@Test
	public void testStockTransfer() throws Exception {
		ByteArrayOutputStream baos = test(StockTransferIT.form(),Resources.STOCK_TRANSFER_RESOURCE);
		assertTrue(baos.size()> 6000 && baos.size() < 60000);
		saveToPdf(baos.toByteArray(), "test-stock-transfer.pdf");
	}

	@Test
	public void testStockTransferWithTax() throws Exception {
		ByteArrayOutputStream baos = test(StockTransferWithTaxIT.form(),Resources.STOCK_TRANSFER_RESOURCE);
		assertTrue(baos.size()> 6000 && baos.size() < 60000);
		saveToPdf(baos.toByteArray(), "test-stock-transfer-with-tax.pdf");
	}

	@Test
	public void testHandover() throws Exception {
		ByteArrayOutputStream baos = test(HandoverIT.form(),Resources.HANDOVER_RESOURCE);
		saveToPdf(baos.toByteArray(), "test-handover.pdf");
	}
	
	public static ByteArrayOutputStream test(Object form, String resource) throws Exception {
		String fopTemplate = VelocityUtil.processVm(form, resource);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), baos);
		return baos;
	}

	private void saveToPdf(byte[] b, String fileName) throws FileNotFoundException, IOException {
		FileOutputStream outputStream = new FileOutputStream("target/" + fileName);
		IOUtils.write(b, outputStream);
		outputStream.close();
	}
}
