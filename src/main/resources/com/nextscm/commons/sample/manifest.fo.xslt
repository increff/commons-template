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
					<fo:region-after region-name="footer" extent="15mm"
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
					<fo:table table-layout="fixed" width="100%">
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>Sender Signature:</fo:block>
									<fo:block>Full Name:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Transporter Signature:</fo:block>
									<fo:block>Full Name :</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-thickness="0.5px" />
					</fo:block>
					<fo:block>
						<fo:block>
							Page
							<fo:page-number />
							(This is a system generated document)
						</fo:block>
					</fo:block>
				</fo:static-content>

				<fo:flow flow-name="body" border-collapse="collapse"
					reference-orientation="0">
					<fo:table table-layout="fixed" width="100%">
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>MANIFEST</fo:block>
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
						<fo:table-column column-width="proportional-column-width(30)" />
						<fo:table-column column-width="proportional-column-width(30)" />
						<fo:table-column column-width="proportional-column-width(30)" />
						<fo:table-column column-width="proportional-column-width(10)" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>Manifest #: BLR/123/345</fo:block>
									<fo:block>Transporter: Ecom-Express
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
									<fo:block>Date: 12 Aug, 1980
									</fo:block>
									<fo:block>Time: 1800
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block></fo:block>
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
						Shipments
					</fo:block>

					<fo:table table-layout="fixed" width="100%">
						<fo:table-column column-number="1" column-width="5%" /> <!--# -->
						<fo:table-column column-number="2" column-width="15%" /><!--Order 
							No. -->
						<fo:table-column column-number="3" column-width="7%" /><!--ZIP -->
						<fo:table-column column-number="4" column-width="10%" /><!--Phone -->
						<fo:table-column column-number="5" column-width="15%" /><!-- 
							AWB -->
						<fo:table-column column-number="6" column-width="15%" /><!--External 
							Order No. -->
						<fo:table-column column-number="7" column-width="5%" /><!--Qty 
							up to 100,000 -->
						<fo:table-column column-number="8" column-width="28%" /><!--Items 
							up to 100,000 -->
						<fo:table-header font-weight="bold">
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>#</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Order #</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>ZIP</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Phone</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>AWB #</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Ext. Order #</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Qty.</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Items</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-header>

						<fo:table-body>
							<fo:table-row border="solid 0.5px black">
								<fo:table-cell>
									<fo:block>1</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<fo:instream-foreign-object>
											<bc:barcode xmlns:bc="http://barcode4j.krysalis.org/ns"
												message="ORD1234">
												<bc:code128>
													<bc:height>8mm</bc:height>
												</bc:code128>
											</bc:barcode>
										</fo:instream-foreign-object>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>560076</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>+91-9900093090</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<fo:instream-foreign-object>
											<bc:barcode xmlns:bc="http://barcode4j.krysalis.org/ns"
												message="AWB1234">
												<bc:code128>
													<bc:height>8mm</bc:height>
												</bc:code128>
											</bc:barcode>
										</fo:instream-foreign-object>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>MYN1233445</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>100</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>HIGHLANDER Product 1</fo:block>
									<fo:block>HIGHLANDER Product 1</fo:block>
								</fo:table-cell>
							</fo:table-row>

						</fo:table-body>
					</fo:table>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>