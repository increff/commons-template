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

import java.util.Date;
import java.util.List;

public class PackingListForm extends AbstractForm {

	private String boxId;
	private Date packingTime;
	private String orderNo;
	private Date orderTime;
	private String channelOrderId;
	private List<PackingListLineItem> lineItems;
	private int totalQuantity;

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public Date getPackingTime() {
		return packingTime;
	}

	public void setPackingTime(Date packingDate) {
		this.packingTime = packingDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderId) {
		this.orderNo = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderDate) {
		this.orderTime = orderDate;
	}

	public List<PackingListLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<PackingListLineItem> packingListLineItems) {
		this.lineItems = packingListLineItems;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getChannelOrderId() {
		return channelOrderId;
	}

	public void setChannelOrderId(String channelOrderId) {
		this.channelOrderId = channelOrderId;
	}
}
