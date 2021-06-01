# commons-template
commons-template provides templates for various applications such as invoices, manifests etc in PDF formats.
## Overview
The commons-template library was created for providing templates for various applications such as invoices, manifests etc in PDF formats. It is extensively used in Assure. It makes use of the Apache Velocity and wkhtmltopdf libraries for creating templates and formats

## Usage
### pom.xml
Include the following dependency in your pom.xml
```xml
<dependency>
    <groupId>com.nextscm.commons</groupId>
    <artifactId>commons-template</artifactId>
    <version>{commons-template.version}</version>
</dependency>
```
## Key Classes
### TemplateApi
This class provides functions to which one can pass the template form or string (the parameters to be populated in the PDF) along with the template resource which can be in the form of .io.vm files or strings. Internally this class makes use of the VelocityUtil and FopUtil to process the data. The template files are written using the XSL-FO ( XSL Formatting Objects formatter) which is then interpreted by the Apache™ FOP (Formatting Objects Processor) which is a Java application that reads a formatting object (FO) tree and renders the resulting pages to a specified output.

```java
public static <T> void getPdfFromVm(String templateResource, T form, OutputStream os)

public static <T> void getPdfFromString(String templateString, T form, OutputStream os)
```

## License
Copyright (c) Increff

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License
is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing permissions and limitations under
the License.
