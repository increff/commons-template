<?xml version="1.0" encoding="UTF-8"?>
<!--
  ~ Copyright (c) 2021. Increff
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
  ~ in compliance with the License. You may obtain a copy of the License at
  ~
  ~ http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software distributed under the License
  ~ is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
  ~ or implied. See the License for the specific language governing permissions and limitations under
  ~ the License.
  -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"
		standalone="no" omit-xml-declaration="no" />
	<xsl:template match="data">
		<fo:root language="EN" font-size="8pt" font-family="arial">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="page-master"
					page-height="297mm" page-width="210mm" margin-top="5mm"
					margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
					<fo:region-body region-name="body" />
					<fo:region-before region-name="header" extent="5mm"
						margin-bottom="5mm" margin-top="5mm" />
					display-align="before" precedence="true" />
					<fo:region-after region-name="footer" extent="5mm"
						margin-bottom="5mm" margin-top="5mm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="page-master">

				<fo:static-content flow-name="header">
					<fo:block>
					</fo:block>
				</fo:static-content>

				<fo:static-content flow-name="footer">
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0.5px" />
					</fo:block>
					<fo:block>
						Page
						<fo:page-number />
						(This is a system generated document)
					</fo:block>
				</fo:static-content>

				<fo:flow flow-name="body" border-collapse="collapse"
					reference-orientation="0">
					<fo:table table-layout="fixed" width="100%">
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>INVOICE</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>COMPANY NAME</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0.5px" />
					</fo:block>
					<!-- INVOICE INFORMATION -->
					<fo:table table-layout="fixed" width="100%">
						<fo:table-column column-width="proportional-column-width(25)" />
						<fo:table-column column-width="proportional-column-width(25)" />
						<fo:table-column column-width="proportional-column-width(25)" />
						<fo:table-column column-width="proportional-column-width(25)" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>Invoice #: BLR/123/345</fo:block>
									<fo:block>Date: 12 Aug, 1980
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<fo:instream-foreign-object>
											<bc:barcode xmlns:bc="http://barcode4j.krysalis.org/ns"
												message="BLR/123/345">
												<bc:code128>
													<bc:height>10mm</bc:height>
													<human-readable>
														<placement>none</placement>
													</human-readable>
												</bc:code128>
											</bc:barcode>
										</fo:instream-foreign-object>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Order #: ORD/123/456
									</fo:block>
									<fo:block>Date: 12 Aug, 1980
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<fo:instream-foreign-object>
											<bc:barcode xmlns:bc="http://barcode4j.krysalis.org/ns"
												message="ORD/123/345">
												<bc:code128>
													<bc:height>10mm</bc:height>
													<human-readable>
														<placement>none</placement>
													</human-readable>
												</bc:code128>
											</bc:barcode>
										</fo:instream-foreign-object>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0.5px" />
					</fo:block>
					<!-- TRANSPORT AND EXTERNAL -->
					<fo:table table-layout="fixed" width="100%">
						<fo:table-column column-width="proportional-column-width(25)" />
						<fo:table-column column-width="proportional-column-width(25)" />
						<fo:table-column column-width="proportional-column-width(50)" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>AWB #: AWB1234
									</fo:block>
									<fo:block>Transporter: E-Com Express
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<fo:instream-foreign-object>
											<bc:barcode xmlns:bc="http://barcode4j.krysalis.org/ns"
												message="AWB1234">
												<bc:code128>
													<bc:height>10mm</bc:height>
													<human-readable>
														<placement>none</placement>
													</human-readable>
												</bc:code128>
											</bc:barcode>
										</fo:instream-foreign-object>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Channel Name: MYNTRA
									</fo:block>
									<fo:block>Channel Order #: EXT-ORD/123/456
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0px" />
					</fo:block>

					<!-- ADDRESS & TAX -->
					<fo:table table-layout="fixed" width="100%">
						<fo:table-column column-width="proportional-column-width(10)" />
						<fo:table-column column-width="proportional-column-width(30)" />
						<fo:table-column column-width="proportional-column-width(30)" />
						<fo:table-column column-width="proportional-column-width(30)" />
						<fo:table-header font-weight="bold">
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>From</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Bill To</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Ship To</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-header>

						<fo:table-body>
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>Tax #</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>From TAX ID</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Bill-To TAX ID</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Ship-To TAX ID</fo:block>
								</fo:table-cell>
							</fo:table-row>

							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>Address</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>From Address</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Bill-To Address</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Ship-To Address</fo:block>
								</fo:table-cell>
							</fo:table-row>

							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>Phone</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>9900093090</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>9900093091</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>9900093092</fo:block>
								</fo:table-cell>
							</fo:table-row>

						</fo:table-body>
					</fo:table>

					<fo:block></fo:block>
					<fo:block></fo:block>

					<!-- LINE ITEMS -->
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0px" />
						Invoice Items (INR)
					</fo:block>

					<fo:table table-layout="fixed" width="100%">
						<fo:table-column column-number="1" column-width="5%" /> <!--# -->
						<fo:table-column column-number="2" column-width="10%" /><!--No. 
							Accommodate EAN -->
						<fo:table-column column-number="3" column-width="10%" /><!--No. 
							Accommodate EAN -->
						<fo:table-column column-number="4" column-width="28%" /><!--Name -->
						<fo:table-column column-number="5" column-width="8%" /><!--MRP 
							up to 100,000 -->
						<fo:table-column column-number="6" column-width="5%" /><!--Qty 
							up to 100,000 -->
						<fo:table-column column-number="7" column-width="8%" /><!--Rate 
							up to 100,000 -->
						<fo:table-column column-number="8" column-width="11%" /><!--Value -->
						<fo:table-column column-number="9" column-width="5%" /><!--Tax 
							% -->
						<fo:table-column column-number="10" column-width="10%" /><!--Amt -->
						<fo:table-header font-weight="bold">
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>#</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Vendor SKU</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Channel SKU</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Item Name</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>MRP</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Qty.</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Rate</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Value</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Tax %</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Amt.</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-header>

						<fo:table-body>
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>1</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>1234567890</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>1234567890</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>HIGHLANDER aCasual Shirt MAROON asdf asdfd asdfsdf
										adsfdsf asdfdsf sadfdsf asdfd asdfasd asdf
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>100001.10</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>100</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>100001.10</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>10000000000</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>7.5</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>10000000000</fo:block>
								</fo:table-cell>
							</fo:table-row>

							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>2</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Shipping Charges</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>30</fo:block>
								</fo:table-cell>
							</fo:table-row>

							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>3</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>COD Charges</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>20</fo:block>
								</fo:table-cell>
							</fo:table-row>

							<!-- SubTotals -->
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Total</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>100</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>10000000000</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>10000000000</fo:block>
								</fo:table-cell>
							</fo:table-row>

						</fo:table-body>
					</fo:table>
					<!-- TAX ITEMS -->
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0px" />
						Tax Items (INR)
					</fo:block>
					<fo:table table-layout="fixed" width="100%">
						<fo:table-column column-number="1" column-width="5%" /> <!--# -->
						<fo:table-column column-number="2" column-width="12%" /><!--No. 
							Accommodate EAN -->
						<fo:table-column column-number="3" column-width="12%" /><!-- 
							HSN -->
						<fo:table-column column-number="4" column-width="10%" /><!--Value -->
						<fo:table-column column-number="5" column-width="10%" /><!--SGST -->
						<fo:table-column column-number="6" column-width="10%" /><!--IGST -->
						<fo:table-column column-number="7" column-width="10%" /><!--CGST -->
						<fo:table-column column-number="8" column-width="10%" /><!--CESS -->
						<fo:table-column column-number="9" column-width="10%" /><!--Taxes -->
						<fo:table-column column-number="10" column-width="11%" /><!--Amount -->
						<fo:table-header font-weight="bold">
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>#</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Vendor SKU</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>HSN</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Value</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>SGST%</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>IGST %</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>CGST %</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>CESS %</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Taxes</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Amt.</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-header>

						<fo:table-body>
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>12345</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>1234567890</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>HSNDEDFGH99</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>100001.10</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>3.5</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>2.5</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>1.5</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Cess</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>10000000000</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>10000000000</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>

					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0px" />
						Remarks
					</fo:block>

					<fo:table>
						<fo:table-body>
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell height="1in">
									<fo:block></fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>



				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>