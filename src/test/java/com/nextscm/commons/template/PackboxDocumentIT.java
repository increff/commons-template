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

import com.nextscm.commons.template.form.Address;
import com.nextscm.commons.template.form.PackboxDocumentForm;
import com.nextscm.commons.template.form.PackingListForm;
import com.nextscm.commons.template.form.PackingListLineItem;
import com.nextscm.commons.template.util.FopUtil;
import com.nextscm.commons.template.util.Utils;
import com.nextscm.commons.template.util.VelocityUtil;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PackboxDocumentIT extends AbstractTest {

    @Test
    public void testPackingList() throws IOException, TransformerException, URISyntaxException, SAXException {
        String fopTemplate = VelocityUtil.processVm(getPackboxDocumentForm(), Resources.PACKBOX_DOCUMENT_RESOURCE);
        FileOutputStream fos = new FileOutputStream("target/test-packbox-document.pdf");
        FopUtil.convertToPDF(Resources.getResource(Resources.FOP_DATA_RESOURCE), Utils.toStream(fopTemplate), fos);
    }

    public static PackboxDocumentForm getPackboxDocumentForm() {
        PackboxDocumentForm form = new PackboxDocumentForm();
        form.setBoxId("1234567890");
        form.setVendorName("TEST VENDOR NAME");
        form.setLength("123");
        form.setBreadth("456");
        form.setHeight(null);
        form.setWeight("147");
        form.setItemCount("50");
        form.setOrderId("84103");
        form.setFromAddress(getAddress("Customer A"));
        form.setToAddress(getAddress("Customer B"));
        form.setShipmentId("183944");
        form.setRemarks("Packbox 10 out of 40");
        return form;
    }

    private static Address getAddress(String name) {
        Address customerAddress = new Address();
        customerAddress.setName(name);
        customerAddress.setCity("Bangalore");
        customerAddress.setCountry("India");
        customerAddress.setEmail("romil.jain@gmail.com");
        customerAddress.setLine1("C2 1502, L&T South City, Arakere");
        customerAddress.setLine2("Bannerghatta Road");
        customerAddress.setPhone("9900093090");
        customerAddress.setState("Karanataka");
        customerAddress.setZip("560076");
        return customerAddress;
    }

}
