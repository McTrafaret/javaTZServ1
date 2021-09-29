package com.udalny.documents.paydocs;

import com.udalny.util.ObjectMapper;
import com.udalny.documents.ServerDocument;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class PayDocs
        extends ServerDocument {

    String GUID_Doc;
    Date Date;
    String Scrc;
    String Vid_Otch;
    int Kol_Doc;
    List<Doc> Docs;

    public PayDocs() {
    }

    public PayDocs(Map<String, Object> map) {

        ObjectMapper.map(this, map);

        Map<String, Object> docMap = (Map<String, Object>) map.get("Docs");
        Docs = Doc.parseDocs(docMap);
    }

    public void setDocs(List<Doc> docs) {
        Docs = docs;
    }

    public String getGUID_Doc() {
        return GUID_Doc;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public String getScrc() {
        return Scrc;
    }

    public String getVid_Otch() {
        return Vid_Otch;
    }

    public int getKol_Doc() {
        return Kol_Doc;
    }

    public List<Doc> getDocs() {
        return Docs;
    }

    @Override
    public String toString() {
        return "PayDocs{" +
                "GUID_Doc='" + GUID_Doc + '\'' +
                ", Date=" + Date +
                ", Scrc='" + Scrc + '\'' +
                ", Vid_Otch='" + Vid_Otch + '\'' +
                ", Kol_Doc=" + Kol_Doc +
                ", Docs=" + Docs +
                '}';
    }
}
