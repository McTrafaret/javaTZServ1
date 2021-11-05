package com.udalny.documents.paydocs;

import com.udalny.documents.ServerDocument;
import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Inf_Pay_Doc")
public class PayDocs
        extends ServerDocument {

    @XmlElement(name = "GUID_Doc")
    private String guidDoc;
    @XmlElement(name = "Date")
    private Date date;
    @XmlAttribute(name = "Scrc")
    private String scrc;
    @XmlAttribute(name = "Vid_Otch")
    private String vidOtch;
    @XmlElement(name = "Kol_Doc")
    private int kolDoc;
    @XmlElementWrapper(name = "Docs")
    @XmlElement(name = "Doc", type = Doc.class)
    private List<Doc> docs;

    public String getGuidDoc() {
        return guidDoc;
    }

    public void setGuidDoc(String guidDoc) {
        this.guidDoc = guidDoc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScrc() {
        return scrc;
    }

    public void setScrc(String scrc) {
        this.scrc = scrc;
    }

    public String getVidOtch() {
        return vidOtch;
    }

    public void setVidOtch(String vidOtch) {
        this.vidOtch = vidOtch;
    }

    public int getKolDoc() {
        return kolDoc;
    }

    public void setKolDoc(int kolDoc) {
        this.kolDoc = kolDoc;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "PayDocs{" +
                "guidDoc='" + guidDoc + '\'' +
                ", date=" + date +
                ", scrc='" + scrc + '\'' +
                ", vidOtch='" + vidOtch + '\'' +
                ", kolDoc=" + kolDoc +
                ", Docs=" + docs +
                '}';
    }
}
