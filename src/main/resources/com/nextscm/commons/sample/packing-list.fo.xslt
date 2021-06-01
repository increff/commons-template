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
									<fo:block>PACKING LIST</fo:block>
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
									<fo:block>Box #: BLR/123/345</fo:block>
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

					<fo:block></fo:block>
					<fo:block></fo:block>

					<!-- LINE ITEMS -->
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0px" />
						Items List
					</fo:block>

					<fo:table table-layout="fixed" width="100%">
						<fo:table-column column-number="1" column-width="10%" /> <!--# -->
						<fo:table-column column-number="2" column-width="20%" /><!--No. 
							Accommodate EAN -->
						<fo:table-column column-number="3" column-width="50%" /><!--Name -->
						<fo:table-column column-number="4" column-width="10%" /><!--MRP 
							up to 100,000 -->
						<fo:table-column column-number="5" column-width="10%" /><!--Qty 
							up to 100,000 -->
						<fo:table-header font-weight="bold">
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>#</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Vendor SKU</fo:block>
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