package com.udalny.documents.paydocs;

import com.udalny.documents.ServerDocument;
import com.udalny.util.ObjectMapper;
import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Inf_Pay_Doc")
public class PayDocs
        extends ServerDocument {

    private String GUID_Doc;
    private Date Date;
    private String Scrc;
    private String Vid_Otch;
    private int Kol_Doc;
    @XmlElementWrapper(name = "Docs")
    @XmlElement(name = "Doc", type = Doc.class)
    private List<Doc> Docs;

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
