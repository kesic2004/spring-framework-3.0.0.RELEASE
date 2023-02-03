import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class RelaceGroupIdDot {

	public static void main(String[] args) {
		String[] inputStringArray = {
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/com.lowagie.text/com.springsource.com.lowagie.text/2.0.8/com.springsource.com.lowagie.text-2.0.8.jar\" sourcepath=\"/IVY_CACHE/com.lowagie.text/com.springsource.com.lowagie.text/2.0.8/com.springsource.com.lowagie.text-sources-2.0.8.jar\"/>",
//				"<classpathentry kind=\"var\" path=\"IVY_CACHE/com.sun.syndication/com.springsource.com.sun.syndication/1.0.0/com.springsource.com.sun.syndication-1.0.0.jar\" sourcepath=\"/IVY_CACHE/com.sun.syndication/com.springsource.com.sun.syndication/1.0.0/com.springsource.com.sun.syndication-sources-1.0.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/javax.activation/com.springsource.javax.activation/1.1.0/com.springsource.javax.activation-1.1.0.jar\" sourcepath=\"/IVY_CACHE/javax.activation/com.springsource.javax.activation/1.1.0/com.springsource.javax.activation-sources-1.1.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/javax.el/com.springsource.javax.el/1.0.0/com.springsource.javax.el-1.0.0.jar\" sourcepath=\"/IVY_CACHE/javax.el/com.springsource.javax.el/1.0.0/com.springsource.javax.el-sources-1.0.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/javax.servlet/com.springsource.javax.servlet.jsp.jstl/1.1.2/com.springsource.javax.servlet.jsp.jstl-1.1.2.jar\" sourcepath=\"/IVY_CACHE/javax.servlet/com.springsource.javax.servlet.jsp.jstl/1.1.2/com.springsource.javax.servlet.jsp.jstl-sources-1.1.2.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/javax.servlet/com.springsource.javax.servlet.jsp/2.1.0/com.springsource.javax.servlet.jsp-2.1.0.jar\" sourcepath=\"/IVY_CACHE/javax.servlet/com.springsource.javax.servlet.jsp/2.1.0/com.springsource.javax.servlet.jsp-sources-2.1.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/javax.servlet/com.springsource.javax.servlet/2.5.0/com.springsource.javax.servlet-2.5.0.jar\" sourcepath=\"/IVY_CACHE/javax.servlet/com.springsource.javax.servlet/2.5.0/com.springsource.javax.servlet-sources-2.5.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/net.sourceforge.jasperreports/com.springsource.net.sf.jasperreports/2.0.5/com.springsource.net.sf.jasperreports-2.0.5.jar\" sourcepath=\"/IVY_CACHE/net.sourceforge.jasperreports/com.springsource.net.sf.jasperreports/2.0.5/com.springsource.net.sf.jasperreports-sources-2.0.5.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/net.sourceforge.jexcelapi/com.springsource.jxl/2.6.6/com.springsource.jxl-2.6.6.jar\" sourcepath=\"/IVY_CACHE/net.sourceforge.jexcelapi/com.springsource.jxl/2.6.6/com.springsource.jxl-sources-2.6.6.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.aopalliance/com.springsource.org.aopalliance/1.0.0/com.springsource.org.aopalliance-1.0.0.jar\" sourcepath=\"/IVY_CACHE/org.aopalliance/com.springsource.org.aopalliance/1.0.0/com.springsource.org.aopalliance-sources-1.0.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.commons/com.springsource.org.apache.commons.fileupload/1.2.0/com.springsource.org.apache.commons.fileupload-1.2.0.jar\" sourcepath=\"/IVY_CACHE/org.apache.commons/com.springsource.org.apache.commons.fileupload/1.2.0/com.springsource.org.apache.commons.fileupload-sources-1.2.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.commons/com.springsource.org.apache.commons.lang/2.1.0/com.springsource.org.apache.commons.lang-2.1.0.jar\" sourcepath=\"/IVY_CACHE/org.apache.commons/com.springsource.org.apache.commons.lang/2.1.0/com.springsource.org.apache.commons.lang-sources-2.1.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.commons/com.springsource.org.apache.commons.logging/1.1.1/com.springsource.org.apache.commons.logging-1.1.1.jar\" sourcepath=\"/IVY_CACHE/org.apache.commons/com.springsource.org.apache.commons.logging/1.1.1/com.springsource.org.apache.commons.logging-sources-1.1.1.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.poi/com.springsource.org.apache.poi/3.0.2.FINAL/com.springsource.org.apache.poi-3.0.2.FINAL.jar\" sourcepath=\"/IVY_CACHE/org.apache.poi/com.springsource.org.apache.poi/3.0.2.FINAL/com.springsource.org.apache.poi-sources-3.0.2.FINAL.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.taglibs/com.springsource.org.apache.taglibs.standard/1.1.2/com.springsource.org.apache.taglibs.standard-1.1.2.jar\" sourcepath=\"/IVY_CACHE/org.apache.taglibs/com.springsource.org.apache.taglibs.standard/1.1.2/com.springsource.org.apache.taglibs.standard-sources-1.1.2.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.velocity/com.springsource.org.apache.velocity.tools.view/1.4.0/com.springsource.org.apache.velocity.tools.view-1.4.0.jar\" sourcepath=\"/IVY_CACHE/org.apache.velocity/com.springsource.org.apache.velocity.tools.view/1.4.0/com.springsource.org.apache.velocity.tools.view-sources-1.4.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.velocity/com.springsource.org.apache.velocity/1.5.0/com.springsource.org.apache.velocity-1.5.0.jar\" sourcepath=\"/IVY_CACHE/org.apache.velocity/com.springsource.org.apache.velocity/1.5.0/com.springsource.org.apache.velocity-sources-1.5.0.jar\"/>",
//				"<classpathentry kind=\"var\" path=\"IVY_CACHE/org.codehaus.jackson/com.springsource.org.codehaus.jackson.mapper/1.0.0/com.springsource.org.codehaus.jackson.mapper-1.0.0.jar\" sourcepath=\"/IVY_CACHE/org.codehaus.jackson/com.springsource.org.codehaus.jackson.mapper/1.0.0/com.springsource.org.codehaus.jackson.mapper-sources-1.0.0.jar\"/>",
//				"<classpathentry kind=\"var\" path=\"IVY_CACHE/org.codehaus.jackson/com.springsource.org.codehaus.jackson/1.0.0/com.springsource.org.codehaus.jackson-1.0.0.jar\" sourcepath=\"/IVY_CACHE/org.codehaus.jackson/com.springsource.org.codehaus.jackson/1.0.0/com.springsource.org.codehaus.jackson-sources-1.0.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.custommonkey.xmlunit/com.springsource.org.custommonkey.xmlunit/1.2.0/com.springsource.org.custommonkey.xmlunit-1.2.0.jar\" sourcepath=\"/IVY_CACHE/org.custommonkey.xmlunit/com.springsource.org.custommonkey.xmlunit/1.2.0/com.springsource.org.custommonkey.xmlunit-sources-1.2.0.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.dom4j/com.springsource.org.dom4j/1.6.1/com.springsource.org.dom4j-1.6.1.jar\" sourcepath=\"/IVY_CACHE/org.dom4j/com.springsource.org.dom4j/1.6.1/com.springsource.org.dom4j-sources-1.6.1.jar\"/>",
//				"<classpathentry kind=\"var\" path=\"IVY_CACHE/org.easymock/com.springsource.org.easymock/2.5.1/com.springsource.org.easymock-2.5.1.jar\" sourcepath=\"/IVY_CACHE/org.easymock/com.springsource.org.easymock/2.5.1/com.springsource.org.easymock-sources-2.5.1.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.freemarker/com.springsource.freemarker/2.3.15/com.springsource.freemarker-2.3.15.jar\" sourcepath=\"/IVY_CACHE/org.freemarker/com.springsource.freemarker/2.3.15/com.springsource.freemarker-sources-2.3.15.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.jaxen/com.springsource.org.jaxen/1.1.1/com.springsource.org.jaxen-1.1.1.jar\" sourcepath=\"/IVY_CACHE/org.jaxen/com.springsource.org.jaxen/1.1.1/com.springsource.org.jaxen-sources-1.1.1.jar\"/>",
//				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.jdom/com.springsource.org.jdom/1.0.0/com.springsource.org.jdom-1.0.0.jar\" sourcepath=\"/IVY_CACHE/org.jdom/com.springsource.org.jdom/1.0.0/com.springsource.org.jdom-1.0.0.jar\"/>",
				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/javax.el/com.springsource.javax.el/1.0.0/com.springsource.javax.el-1.0.0.jar\" sourcepath=\"/IVY_CACHE/javax.el/com.springsource.javax.el/1.0.0/com.springsource.javax.el-sources-1.0.0.jar\"/>",
				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/javax.inject/com.springsource.javax.inject/1.0.0/com.springsource.javax.inject-1.0.0.jar\" sourcepath=\"/IVY_CACHE/javax.inject/com.springsource.javax.inject/1.0.0/com.springsource.javax.inject-sources-1.0.0.jar\"/>",
				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/net.sourceforge.cglib/com.springsource.net.sf.cglib/2.2.0/com.springsource.net.sf.cglib-2.2.0.jar\" sourcepath=\"/IVY_CACHE/net.sourceforge.cglib/com.springsource.net.sf.cglib/2.1.3/com.springsource.net.sf.cglib-sources-2.1.3.jar\"/>",
				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.apache.log4j/com.springsource.org.apache.log4j/1.2.15/com.springsource.org.apache.log4j-1.2.15.jar\" sourcepath=\"/IVY_CACHE/org.apache.log4j/com.springsource.org.apache.log4j/1.2.15/com.springsource.org.apache.log4j-sources-1.2.15.jar\"/>",
				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.junit/com.springsource.org.junit/4.7.0/com.springsource.org.junit-4.7.0.jar\" sourcepath=\"/IVY_CACHE/org.junit/com.springsource.org.junit/4.7.0/com.springsource.org.junit-sources-4.6.0.jar\"/>",
				"<classpathentry kind=\"lib\" path=\"IVY_CACHE/org.easymock/com.springsource.org.easymock/2.5.1/com.springsource.org.easymock-2.5.1.jar\" sourcepath=\"/IVY_CACHE/org.easymock/com.springsource.org.easymock/2.5.1/com.springsource.org.easymock-sources-2.5.1.jar\"/>",
		};
		SAXReader reader = new SAXReader();
		Document  doc    = null;
		Element   root   = null;
		String    kind   = null; // var
		String    path   = null; // IVY_CACHE/org.junit/com.springsource.org.junit/4.6.0/com.springsource.org.junit-4.6.0.jar
		String    sp     = null; // sourcepath /IVY_CACHE/org.junit/com.springsource.org.junit/4.6.0/com.springsource.org.junit-sources-4.6.0.jar
		for (int i = 0; i < inputStringArray.length; ++i) {
			try {
				doc  = reader.read(new StringReader(inputStringArray[i]));
				root = doc.getRootElement();
				kind = root.attributeValue("kind");
				if("lib".equals(kind)) {
					path = root.attributeValue("path");
					sp   = root.attributeValue("sourcepath");
					if(sp == null || sp.length() == 0) {
						System.out.println(String.format("\t<classpathentry kind=\"%s\" path=\"%s\"/>", kind, processGroupId(path)));
					} else {
						System.out.println(String.format("\t<classpathentry kind=\"%s\" path=\"%s\" sourcepath=\"%s\"/>", kind, processGroupId(path), processMinusSources(processGroupId(sp))));
					}
				} else {
					System.out.print('\t');
					System.out.println(inputStringArray[i]);
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}

	private static String processGroupId(String path) {
		int leftIndex = path.indexOf("IVY_CACHE/");
		if(leftIndex < 0) {
			return path;
		}
		leftIndex += 10;
//		String a = "F:/repo1"; // path.substring(0, leftIndex);
		String b = path.substring(leftIndex);
		int rightIndex = b.indexOf('/');
		if(rightIndex < 0) {
			return path;
		}
		String c = b.substring(0, rightIndex).replace('.', '/');
		String d = b.substring(rightIndex);
		return String.format("F:/repo1/%s%s", c, d);
	}
	private static String processMinusSources(String path) {
		int leftIndex = path.lastIndexOf('/');
		if(leftIndex < 0) {
			return path;
		}
		String a = path.substring(0, leftIndex);
		String b = path.substring(leftIndex);
		int middleIndex = b.lastIndexOf("-sources");
		if(middleIndex < 0) {
			return path;
		}
		String c = b.substring(0, middleIndex);
		String d = b.substring(middleIndex + 8);
		int rightIndex = d.lastIndexOf("jar");
		if(rightIndex < 0) {
			return path;
		}
		String e = d.substring(0, rightIndex - 1);
		return String.format("%s%s%s-sources.jar", a, c, e);
	}
}
