package com.udalny.documents.report;

import com.udalny.util.ObjectMapper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.*;

@XmlRootElement(name = "Doc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Doc {

    private int Line_Num;
    private int DocNum;
    private Date DocDate;
    private String DocGUID;
    private String OperType;
    private String Bic_Corr;
    private BigDecimal AmountIn;
    private BigDecimal AmountOut;
    private String SendAcc;
    private String RecipAcc;
    private String PurpPay;

    public Doc() {
    }

    public Doc(Map<String, Object> map) {
        ObjectMapper.map(this, map);
    }

    public static List<Doc> parseDocs(Map<String, Object> map) {
        LinkedList<Doc> ret = new LinkedList<>();
        LinkedList<Object> docs = (LinkedList<Object>) map.get("Doc");
        Iterator<Object> iter = docs.iterator();
        iter.next();
        while (iter.hasNext()) {
            Map<String, Object> docMap = (Map<String, Object>) iter.next();
            ret.add(new Doc(docMap));
        }

        return ret;
    }

    public int getLine_Num() {
        return Line_Num;
    }

    public int getDocNum() {
        return DocNum;
    }

    public Date getDocDate() {
        return DocDate;
    }

    public String getDocGUID() {
        return DocGUID;
    }

    public String getOperType() {
        return OperType;
    }

    public String getBic_Corr() {
        return Bic_Corr;
    }

    public BigDecimal getAmountIn() {
        return AmountIn;
    }

    public BigDecimal getAmountOut() {
        return AmountOut;
    }

    public String getSendAcc() {
        return SendAcc;
    }

    public String getRecipAcc() {
        return RecipAcc;
    }

    public String getPurpPay() {
        return PurpPay;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "Line_Num=" + Line_Num +
                ", DocNum=" + DocNum +
                ", DocDate=" + DocDate +
                ", DocGUID='" + DocGUID + '\'' +
                ", OperType='" + OperType + '\'' +
                ", Bic_Corr='" + Bic_Corr + '\'' +
                ", AmountIn=" + AmountIn +
                ", AmountOut=" + AmountOut +
                ", SendAcc='" + SendAcc + '\'' +
                ", RecipAcc='" + RecipAcc + '\'' +
                ", PurpPay='" + PurpPay + '\'' +
                '}';
    }
}
