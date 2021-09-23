package com.udalny.documents;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

public class SummaryDocumentFactory
{
	private static String getGUIDFromDoc(HashMap<String, Object> map)
	{
		if(map.containsKey("GUID"))
		{
			return (String) map.get("GUID");
		}
		else
			return (String) map.get("DocGUID");
	}

	private static HashMap<String, HashMap<String, Object>> mapGUIDToDocs(LinkedList<HashMap<String, Object>> docs)
	{
		Iterator<HashMap<String, Object>> iter = docs.iterator();
		HashMap<String, HashMap<String, Object>> res = new HashMap<String, HashMap<String, Object>>();

		iter.next();
		while(iter.hasNext())
		{
			HashMap<String, Object> map = iter.next();
			res.put(getGUIDFromDoc(map), map);
		}

		return res;
	}

	public static LinkedList<SummaryDocument> getListOfSummaryDocuments(Report report, PayDocs paydocs)
	{
		LinkedList<SummaryDocument> list = new LinkedList<SummaryDocument>();

		LinkedList<HashMap<String, Object>> reportDocs = report.getListOfDocs();
		LinkedList<HashMap<String, Object>> paydocsDocs = paydocs.getListOfDocs();

		HashMap<String, HashMap<String, Object>> guidmap = mapGUIDToDocs(paydocsDocs);

		Iterator<HashMap<String, Object>> iter = reportDocs.iterator();

		iter.next();
		while(iter.hasNext())
		{
			HashMap<String, Object>  map = iter.next();
			String reportGUID = getGUIDFromDoc(map);
			if(guidmap.containsKey(reportGUID))
			{
				SummaryDocument summary = new SummaryDocument(map, guidmap.get(reportGUID));
				list.add(summary);
			}
		}

		return list;
	}

	public static LinkedList<SummaryDocument> getListOfSummaryDocuments(DocumentPair pair)
	{
		return getListOfSummaryDocuments(pair.getReport(), pair.getPaydocs());
	}
}
