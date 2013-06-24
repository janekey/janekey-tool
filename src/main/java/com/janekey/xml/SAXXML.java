package com.janekey.xml;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Stack;

/**
 * 
 * @author ZQKEY
 * SAX	处理效率高
 */
public class SAXXML extends DefaultHandler {
	
	@SuppressWarnings("rawtypes")
	private Stack tags = new Stack();
	
	public SAXXML() {
		super();
	}
	
	public static void main(String[] args) {
		SAXParser sp;
		try {
			sp = SAXParserFactory.newInstance().newSAXParser();
			SAXXML sr = new SAXXML();
			sp.parse(new InputSource("src/zqkey/tool/xml/zqkey.xml"), sr);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String tag = (String)tags.peek();
		if(tag.equals("number")) {
			System.out.println("number\t" + new String(ch, start, length));
		}
		if(tag.equals("name")) {
			System.out.println("name\t" + new String(ch, start, length));
		}
		if(tag.equals("stu_num")) {
			System.out.println("stu_num\t" + new String(ch, start, length));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) throws SAXException {
		tags.push(qName);
		System.out.println("startElement");
	}

}
