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

package com.increff.commons.template.form;

/**
 * Created by koushik on 13/3/17.
 */
public class ShippingLabelForm {

	private String gstin;

	private String title;

	private Address toAddress;

	private String orderNo;

	private String invoiceNo;

	private String awbNo;

	private String transporterName;

	// warehouse address
	private Address returnAddress;

	private double codAmount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String courier) {
		this.transporterName = courier;
	}

	public Address getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(Address returnAddress) {
		this.returnAddress = returnAddress;
	}

	public double getCodAmount() {
		return codAmount;
	}

	public void setCodAmount(double codAmount) {
		this.codAmount = codAmount;
	}

	public Address getToAddress() {
		return toAddress;
	}

	public void setToAddress(Address customerAddress) {
		this.toAddress = customerAddress;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAwbNo() {
		return awbNo;
	}

	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

}
