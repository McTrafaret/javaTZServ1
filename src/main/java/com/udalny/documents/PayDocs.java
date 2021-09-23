package com.udalny.documents;

import java.util.Date;
import java.util.LinkedList;
import java.util.HashMap;

public class PayDocs
	extends ServerDocument
{
	private String GUIDDoc;
	private Date Date;
	private int Scrc;
	private int VidOtch;
	private int KolDoc;
	private LinkedList<HashMap<String, String>> Docs;

	public PayDocs(HashMap<String, Object> map)
	{
		super(map);
	}

	@Override
	protected boolean compareGUID(HashMap<String, Object> map, String GUID)
	{
			if(map.containsKey("GUID"))
			{
				String guid = (String) map.get("GUID");
				return guid.equalsIgnoreCase(GUID);
			}
			else
				return false;
	}

    public String getGUIDDoc() {
        return GUIDDoc;
    }
    public void setGUIDDoc(String gUIDDoc) {
        GUIDDoc = gUIDDoc;
    }
    public Date getDate() {
        return Date;
    }
    public void setDate(Date date) {
        Date = date;
    }
    public int getScrc() {
        return Scrc;
    }
    public void setScrc(int scrc) {
        Scrc = scrc;
    }
    public int getVidOtch() {
        return VidOtch;
    }
    public void setVidOtch(int vidOtch) {
        VidOtch = vidOtch;
    }
    public int getKolDoc() {
        return KolDoc;
    }
    public void setKolDoc(int kolDoc) {
        KolDoc = kolDoc;
    }
    public LinkedList<HashMap<String, String>> getDocs() {
        return Docs;
    }
    public void setDocs(LinkedList<HashMap<String, String>> docs) {
        Docs = docs;
    }
}
