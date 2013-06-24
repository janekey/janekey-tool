package com.janekey.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JDOMXML {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(new File("src/zqkey/tool/xml/zqkey.xml"));
			Element school = doc.getRootElement();
			System.out.println(school.getName());
			List schoolchildrens = school.getChildren();
			for(int i=0; i<schoolchildrens.size(); i++) {
				Element xml_class = (Element) schoolchildrens.get(i);
				System.out.println(xml_class.getName());
				 List classChildrens = ((Element) schoolchildrens.get(i)).getChildren();
				 for(int j=0; j<classChildrens.size(); j++) {
					 Element classChildren = (Element) classChildrens.get(j);
					 System.out.println(classChildren.getName() + " : " + classChildren.getValue());
				 }
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
