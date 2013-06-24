package com.janekey.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author ZQKEY
 * DOM	解析和加载整个文档
 */
public class DOMXML {
	
	public static void main(String args[]) {
		try {
			// 获取解析对象
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			// 文档的树模型
			Document doc = builder.parse(new File("src/zqkey/tool/xml/zqkey.xml"));
			
			NodeList schoolList = doc.getElementsByTagName("school");
			if(schoolList.getLength() > 0) {
				Node school = schoolList.item(0);
				System.out.println(school.getNodeName());
				
				NodeList classList = doc.getElementsByTagName("class");
				for(int i=0; i<classList.getLength(); i++) {
					Node classNode = classList.item(i);
					System.out.println(classNode.getNodeName());
					
					System.out.println("number\t" + doc.getElementsByTagName("number").item(i).getFirstChild().getNodeValue());
					System.out.println("name\t" + doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
					System.out.println("stu_num\t" + doc.getElementsByTagName("stu_num").item(i).getFirstChild().getNodeValue());
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
