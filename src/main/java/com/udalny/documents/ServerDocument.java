package com.udalny.documents;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;

public abstract class ServerDocument
{
	private HashMap<String, Object> map;

	protected abstract boolean compareGUID(HashMap<String, Object> map, String GUID);

	public ServerDocument(HashMap<String, Object> map)
	{
		this.map = map;
	}

	public HashMap<String, Object> getDocByGUID(String GUID)
	{
		Object temp;
		HashMap<String, Object> ret;

		if(map == null)
			return null;

		ret = (HashMap<String, Object>) map.get("Docs");
		temp = ret.get("Doc");
		if(temp instanceof LinkedList<?>)
		{
			LinkedList<HashMap<String, Object>> list =
				(LinkedList<HashMap<String, Object>>) temp;
			Iterator<HashMap<String, Object>> iter = list.iterator();
			iter.next();
			while(iter.hasNext())
			{
				ret = iter.next();
				if(compareGUID(ret, GUID))
					return ret;
			}
			return null;
		}
		else
		{
			ret = (HashMap<String, Object>) temp;
			if(compareGUID(ret, GUID))
				return ret;
			else
				return null;
		}
	}

	public LinkedList<HashMap<String, Object>> getListOfDocs()
	{
		LinkedList<HashMap<String, Object>> ret;
		HashMap<String, Object> tempmap;
		Object temp;

		if(map == null)
			return null;

		tempmap = (HashMap<String, Object>) map.get("Docs");
		temp = tempmap.get("Doc");
		if(temp instanceof LinkedList<?>)
		{
			return (LinkedList<HashMap<String, Object>>) temp;
		}
		else
		{
			ret = new LinkedList<HashMap<String, Object>>();
			ret.add((HashMap<String, Object>) temp);
		}

		return ret;
	}
}
