package com.udalny.documents.report;

import com.udalny.util.ObjectMapper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "StmInfrmtn_TF")
@XmlAccessorType(XmlAccessType.FIELD)
public class StmInfrmtnTF {
    String GUID;

    public StmInfrmtnTF() {
    }

    public StmInfrmtnTF(Map<String, Object> map) {
        ObjectMapper.map(this, map);
    }

    @Override
    public String toString() {
        return "StmInfrmtnTF{" +
                "GUID='" + GUID + '\'' +
                '}';
    }
}
