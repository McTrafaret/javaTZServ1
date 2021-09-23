package com.udalny.documents;

import java.util.zip.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.regex.*;

public class ZipHandler
{
	ZipFile zip;
	LinkedList<ZipEntry> entriesList;
	private static final String contentsError = "Not valid format of zip file(need two xml documents)";

	private void leaveOnlyXMLInEntriesList(LinkedList<ZipEntry> list)
	{
		Iterator<ZipEntry> iter = list.iterator();
		Pattern pattern = Pattern.compile(".*\\.xml", Pattern.CASE_INSENSITIVE);
		iter.next();
		while(iter.hasNext())
		{
			ZipEntry entry = iter.next();
			String filename = entry.getName();
			Matcher m = pattern.matcher(filename);
			if(!m.matches())
			{
				iter.remove();
			}
		}
	}

	public ZipHandler(String Filename)
	{
		try
		{
			zip = new ZipFile(Filename);
		}
		catch(IOException ex)
		{
		}
		entriesList = new LinkedList<ZipEntry>();
		Enumeration<? extends ZipEntry> e = zip.entries();
		while(e.hasMoreElements())
		{
			ZipEntry entry = e.nextElement();
			entriesList.add(entry);
		}
	}

	public DocumentPair getDocuments()
		throws Exception
	{
		ServerDocument a, b;
		LinkedList<ZipEntry> temp = (LinkedList<ZipEntry>) entriesList.clone();
		leaveOnlyXMLInEntriesList(temp);
		if(temp.size() != 2)
		{
			throw new Exception(contentsError);
		}

		try
		{
			a = ServerDocumentFactory.getDocument(zip.getInputStream(temp.get(0)));
			b = ServerDocumentFactory.getDocument(zip.getInputStream(temp.get(1)));
		}
		catch(Exception ex)
		{
			System.err.println(ex);
			System.err.println("Can't parse");
			return null;
		}

		return new DocumentPair(a, b);
	}
}
