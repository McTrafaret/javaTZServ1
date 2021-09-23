package com.udalny.documents;

import java.util.HashMap;
import java.io.InputStream;
import com.udalny.xml.*;

public class ServerDocumentFactory
{
	private static final String PayDocsTag = "Inf_Pay_Doc";
	private static final String ReportTag = "SKP_REPORT_KS";

	public static ServerDocument getDocument(HashMap<String, Object> map)
	{
		if(map.containsKey(PayDocsTag))
			return new PayDocs((HashMap<String, Object>) map.get(PayDocsTag));
		else if(map.containsKey(ReportTag))
			return new Report((HashMap<String, Object>) map.get(ReportTag));

		return null;
	}

	public static ServerDocument getDocument(String XMLFilename)
	{
		DOMXMLParser parser = new DOMXMLParser(XMLFilename);
		HashMap<String, Object> map = parser.parse();
		return getDocument(map);
	}

	public static ServerDocument getDocument(InputStream in)
	{
		DOMXMLParser parser = new DOMXMLParser(in);
		HashMap<String, Object> map = parser.parse();
		return getDocument(map);
	}
}
