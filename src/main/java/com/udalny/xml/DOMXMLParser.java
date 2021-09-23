package com.udalny.xml;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import java.util.*;
import java.io.InputStream;
import java.io.FileInputStream;

public class DOMXMLParser
	extends XMLParser
{
	private InputStream in;

	private boolean hasChildElements(Element el)
	{
		NodeList children = el.getChildNodes();
		for(int i = 0; i < children.getLength(); i++)
		{
			if(children.item(i).getNodeType() == Node.ELEMENT_NODE)
				return true;
		}

		return false;
	}

	private String getTextValue(Element el)
	{
		NodeList children = el.getChildNodes();
		StringBuilder value = new StringBuilder();
		for(int i = 0; i < children.getLength(); i++)
		{
			if(children.item(i).getNodeType() == Node.TEXT_NODE)
				value.append(children.item(i).getNodeValue());
		}
		return value.toString();
	}

	private void addTagToHashMap(HashMap<String, Object> map, String tagName, Object value)
	{
		if(map.containsKey(tagName))
		{
			// System.out.println("Opa");
			Object mappedTo = map.get(tagName);
			LinkedList<Object> list;
			if(mappedTo instanceof LinkedList<?>)
			{
				list = (LinkedList<Object>) mappedTo;
			}
			else
			{
				list = new LinkedList<Object>();
				map.put(tagName, list);
				list.add(map.get(tagName));
			}
			list.add(value);
		}
		else
		{
			map.put(tagName, value);
		}
	}

	private void parseElement(HashMap<String, Object> map, Element el)
	{
		if(!hasChildElements(el))
		{
			// System.out.printf("%s: %s\n", el.getTagName(), el.getNodeValue());
			addTagToHashMap(map, el.getTagName(), getTextValue(el));
		}
		else
		{
			HashMap<String, Object> submap = new HashMap<String, Object>();
			NodeList childs = el.getChildNodes();
			for(int i = 0; i < childs.getLength(); i++)
			{
				if(childs.item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					Element child = (Element) childs.item(i);
					parseElement(submap, child);
				}
			}
			addTagToHashMap(map, el.getTagName(), submap);
		}
	}

	public DOMXMLParser(String filename)
	{
		try
		{
			in = new FileInputStream(filename);
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
	}

	public DOMXMLParser(InputStream in)
	{
		this.in = in;
	}

	public HashMap<String, Object> parse()
	{
		HashMap<String, Object> res = new HashMap<String, Object>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		try
		{
			builder = factory.newDocumentBuilder();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}

		try
		{
			doc = builder.parse(in);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}


		Element root = doc.getDocumentElement();
		parseElement(res, root);


		return res;
	}
}
