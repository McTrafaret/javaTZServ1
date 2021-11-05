package com.udalny.documents.report;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "StmInfrmtn_TF")
@XmlAccessorType(XmlAccessType.FIELD)
public class StmInfrmtnTF {

    @XmlElement(name = "GUID")
    private String guid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "StmInfrmtnTF{" +
                "guid='" + guid + '\'' +
                '}';
    }
}
