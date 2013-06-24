package com.janekey.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @author ZHENGQ08
 * 从性能等各个角度DOM4J优势最大
 */
public class DOM4JXML {
	
	public static void main(String[] args) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("src/zqkey/tool/xml/zqkey.xml"));
			Element root = doc.getRootElement();
			System.out.println(root.getName());
			List<Element> a= root.elements("class");
			for(int i=0; i<a.size(); i++) {
				System.out.println(a.get(i).getName());
				System.out.println(a.get(i).element("number").getName() + " : " + a.get(i).elementText("number"));
				System.out.println(a.get(i).element("name").getName() + " : " + a.get(i).elementText("name"));
				System.out.println(a.get(i).element("stu_num").getName() + " : " + a.get(i).elementText("stu_num"));
			}
			System.out.println();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
