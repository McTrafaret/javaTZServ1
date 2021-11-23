package com.udalny.documents.report;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement(name = "Doc")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportDoc {

    @XmlElement(name = "Line_Num")
    private int lineNum;
    @XmlElement(name = "DocNum")
    private String docNum;
    @XmlElement(name = "DocDate")
    private Date docDate;
    @XmlElement(name = "DocGUID")
    private String docGUID;
    @XmlElement(name = "OperType")
    private String operType;
    @XmlElement(name = "Bic_Corr")
    private String bicCorr;
    @XmlElement(name = "AmountIn")
    private BigDecimal amountIn;
    @XmlElement(name = "AmountOut")
    private BigDecimal amountOut;
    @XmlElement(name = "SendAcc")
    private String sendAcc;
    @XmlElement(name = "RecipAcc")
    private String recipAcc;
    @XmlElement(name = "PurpPay")
    private String purpPay;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocGUID() {
        return docGUID;
    }

    public void setDocGUID(String docGUID) {
        this.docGUID = docGUID;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getBicCorr() {
        return bicCorr;
    }

    public void setBicCorr(String bicCorr) {
        this.bicCorr = bicCorr;
    }

    public BigDecimal getAmountIn() {
        return amountIn;
    }

    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    public BigDecimal getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    public String getSendAcc() {
        return sendAcc;
    }

    public void setSendAcc(String sendAcc) {
        this.sendAcc = sendAcc;
    }

    public String getRecipAcc() {
        return recipAcc;
    }

    public void setRecipAcc(String recipAcc) {
        this.recipAcc = recipAcc;
    }

    public String getPurpPay() {
        return purpPay;
    }

    public void setPurpPay(String purpPay) {
        this.purpPay = purpPay;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "lineNum=" + lineNum +
                ", docNum=" + docNum +
                ", docDate=" + docDate +
                ", docGUID='" + docGUID + '\'' +
                ", operType='" + operType + '\'' +
                ", bicCorr='" + bicCorr + '\'' +
                ", amountIn=" + amountIn +
                ", amountOut=" + amountOut +
                ", sendAcc='" + sendAcc + '\'' +
                ", recipAcc='" + recipAcc + '\'' +
                ", purpPay='" + purpPay + '\'' +
                '}';
    }
}
