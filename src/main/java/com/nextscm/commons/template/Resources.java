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

import java.io.InputStream;

public class Resources {

	public static final String BASE_PACKAGE = "/com/nextscm/commons/template";

	public static final String INVOICE_RESOURCE = BASE_PACKAGE + "/invoice.fo.vm";
	public static final String STOCK_TRANSFER_RESOURCE = BASE_PACKAGE + "/stock-transfer.fo.vm";
	public static final String HANDOVER_RESOURCE = BASE_PACKAGE + "/handover.fo.vm";
	public static final String MANIFEST_RESOURCE = BASE_PACKAGE + "/manifest.fo.vm";
	public static final String PACKING_LIST_RESOURCE = BASE_PACKAGE + "/packing-list.fo.vm";
	public static final String SHIPPING_LABEL_RESOURCE = BASE_PACKAGE + "/shipping-label.fo.vm";
	public static final String UPB_PACKLIST_RESOURCE = BASE_PACKAGE + "/upb-packing-list.fo.vm";


	public static final String FOP_DATA_RESOURCE = BASE_PACKAGE + "/fop-data.xml";

	public static InputStream getResource(String resource) {
		return Resources.class.getResourceAsStream(resource);
	}
}
