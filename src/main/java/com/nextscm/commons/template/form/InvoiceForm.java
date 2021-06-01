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

package com.nextscm.commons.template.form;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class InvoiceForm extends AbstractForm {

	private String invoiceOrStockTransferNo;
	private Date invoiceOrStockTransferTime;

	private String orderNo;
	private Date orderTime;
	private String channelName;
	private String channelOrderNo;

	private String fromPartyName;
	private String toPartyName;
	private String fromTaxId;
	private String toTaxId;

	private String panNo;

	private Address fromAddress;
	private Address billingAddress;
	private Address shippingAddress;

	private int quantity;

	/*TOTAL AMOUNT EXCLUDING THE SERVICE ITEM AMOUNT*/
	private double subBaseAmount;
	private double subTaxAmount;
	private double subTotalAmount;

	/*TOTAL AMOUNT INCLUDES SUB AMOUNT AND SERVICE ITEM AMOUNT*/
	//TODO : set the values directly in getter
	private double finalBaseAmount;
	private double finalTaxAmount;
	private double finalTotalAmount;

	private List<InvoiceLineItem> itemLines;
	private List<ServiceLineItem> serviceLines;
	private boolean invoiceCancelled;

	private String signatureUrl;

}
