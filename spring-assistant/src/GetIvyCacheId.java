import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class GetIvyCacheId {

	private static final File ROOT_DIRECTORY;
	static {
		ROOT_DIRECTORY = new File("F:\\spring-framework-3.0.x\\spring-framework-3.0.0.M4");
	}
	private static final Set<String> PROJECT_REFERENCE;
	static {
		PROJECT_REFERENCE = new HashSet<String>();
	}
	private static FileWriter fileWriter;

	/**
	 * @Title: main
	 * @Description: 获取ANT配置文件中的groupId、artifactId、version三要素
	 * @param args
	 * @throws IOException 
	 * @createdBy:ak
	 * @createaAt:2020-07-26下午15:05:31
	 */
	public static void main(String[] args) throws IOException {
		File[] springFrameworkMoudleArray = ROOT_DIRECTORY.listFiles(new MyClasspathFilenameFilter());
		String outputFileName             = String.format("out_%s.txt", Long.toString(System.currentTimeMillis()));
		int    insertLine                 = 0;
		try {
			fileWriter = new FileWriter(new File(ROOT_DIRECTORY, outputFileName), true);
			fileWriter.write("---");
			fileWriter.write("\r\n");
			for(File file : springFrameworkMoudleArray) {
				process(new File(file, ".classpath"), file, outputFileName, insertLine);
			}
			for(String string : PROJECT_REFERENCE) {
				fileWriter.write(String.format("/string-%s", string.substring(21).replace('.', '-')));
				fileWriter.write("\r\n");
			}
		} finally {
			if(fileWriter != null) {
				fileWriter.close();
			}
		}
	}


	/**
	 * @Title: process
	 * @Description: 处理具体的.classpath文件
	 * @param file
	 * @param inputFile
	 * @param outputBaseDirectory
	 * @param outputFileName
	 * @param insertLine
	 * @throws IOException 
	 * @createdBy:ak
	 * @createaAt:2020-7-26下午4:40:45
	 */
	private static void process(File xml, File outputBaseDirectory, String outputFileName, int insertLine) throws IOException {
		DocumentBuilderFactory dbf        = DocumentBuilderFactory.newInstance();
		DocumentBuilder        builder    = null;
		Document               doc        = null;
		Element                root       = null;
		NodeList               list       = null;
		Node                   item       = null;
		Element                child      = null;
		String                 path       = null;
		String                 sourcepath = null;
		int                    indexP     = 0;
		int                    indexS     = 0;
		final int              length;
		FileWriter             out        = null;
		fileWriter.write(xml.getAbsolutePath());
		fileWriter.write("\r\n");
		try {
			builder = dbf.newDocumentBuilder();
			doc     = builder.parse(xml);
			root    = doc.getDocumentElement();
			list    = root.getChildNodes();
			length  = list.getLength();
			out     = new FileWriter(new File(outputBaseDirectory, outputFileName));
			for(int i = 0; i < length; ++i) {
				item = list.item(i);
				if(item.getNodeType() == Element.ELEMENT_NODE) {
					child = (Element)item;
					if(isProjectReference(child)) {
//						System.out.println(String.format("path=\"%s\"", child.getAttribute("path")));
						PROJECT_REFERENCE.add(child.getAttribute("path"));
						continue;
					}
					if(isLibrary(child)) {
						if(child.hasAttribute("sourcepath")) {
							path       = child.getAttribute("path");
							sourcepath = child.getAttribute("sourcepath");
							indexP     = path.indexOf("IVY_CACHE/");
							indexS     = sourcepath.indexOf("IVY_CACHE/");
							if(indexP < 0 || indexS < 0) {
								showChild(child);
								continue;
							}
							path = path.substring(indexP + 10);
							sourcepath = sourcepath.substring(indexS + 10);
							GroupIdArtifactIdVersionBean refJar = getGroupIdArtifactIdVersionBean(path);
							GroupIdArtifactIdVersionBean srcJar = getGroupIdArtifactIdVersionBean(sourcepath);
							if(refJar == null || srcJar == null || !refJar.equals(srcJar)) {
								showChild(child);
								continue;
							}
							out.write(refJar.format("        <dependency>\r\n            <groupId>%s</groupId>\r\n            <artifactId>%s</artifactId>\r\n            <version>%s</version>\r\n        </dependency>\r\n"));
						} else {
							path       = child.getAttribute("path");
							indexP     = path.indexOf("IVY_CACHE/");
							if(indexP < 0) {
								showChild(child);
								continue;
							}
							path = path.substring(indexP + 10);
							GroupIdArtifactIdVersionBean refJar = getGroupIdArtifactIdVersionBean(path);
							if(refJar == null) {
								showChild(child);
							}
							out.write(refJar.format("    <dependency>\r\n        <groupId>%s</groupId>\r\n        <artifactId>%s</artifactId>\r\n        <version>%s</version>\r\n    </dependency>\r\n"));
						}
						continue;
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SAXException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		fileWriter.write("\r\n");
	}


	private static GroupIdArtifactIdVersionBean getGroupIdArtifactIdVersionBean(String string) {
		String[] stringArray = string.split("/");
		if(stringArray.length < 3) {
			return null;
		}
		return new GroupIdArtifactIdVersionBean(stringArray[0], stringArray[1], stringArray[2]);
	}


	private static boolean isProjectReference(Element child) {
		return child.getNodeName().equals("classpathentry") && child.getAttribute("combineaccessrules").equals("false") && child.getAttribute("kind").equals("src");
	}


	private static boolean isLibrary(Element child) {
		return child.getNodeName().equals("classpathentry") && child.getAttribute("kind").equals("var");
	}


	private static void showChild(Element element) throws IOException {
		String name = element.getNodeName();
		NamedNodeMap attributes = element.getAttributes();
		int length = attributes.getLength();
		StringBuilder temp = new StringBuilder();
		temp.append((char)'<');
		temp.append(name);
		for(int i = 0; i < length; ++i) {
			temp.append((char)' ');
			temp.append(attributes.item(i).getNodeName());
			temp.append((char)'=');
			temp.append((char)'\"');
			temp.append(attributes.item(i).getNodeValue());
			temp.append((char)'\"');
		}
		temp.append((char)'>');
		temp.append((char)'<');
		temp.append((char)'/');
		temp.append(name);
		temp.append((char)'>');
		fileWriter.write(temp.toString());
		fileWriter.write("\r\n");
	}

}

class MyClasspathFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		File file = new File(dir, name);
		return (name.startsWith("spring-") && file.exists() && file.isDirectory() && (new File(file, ".classpath").exists()) && (new File(file, "0.classpath").exists()));
	}
	
}