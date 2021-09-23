package com.udalny;

import com.udalny.xml.*;
import com.udalny.documents.*;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
		for(int i = 0; i < args.length; i++)
			System.out.println(args[i]);
		if(args.length != 2)
		{
			System.err.println("Please specify xml files");
			return;
		}
		// DOMXMLParser parser = new DOMXMLParser(args[0]);
		HashMap<String, Object> map;
		// map = parser.parse();
		// map = (HashMap<String, Object>) map.get("Inf_Pay_Doc");
		// // System.out.println(map);
		// map = (HashMap<String, Object>) map.get("Docs");
		// // System.out.println(map);
		// System.out.println(map.get("Doc"));
		Report report = (Report) ServerDocumentFactory.getDocument(args[0]);
		PayDocs paydocs = (PayDocs) ServerDocumentFactory.getDocument(args[1]);
		// map = doc.getDocByGUID("ba44ab7a-1342-19a7-e054-001e0b59efca");
		// System.out.println(doc.getListOfDocs());
		System.out.println(SummaryDocumentFactory.getListOfSummaryDocuments(report, paydocs));
    }
}
