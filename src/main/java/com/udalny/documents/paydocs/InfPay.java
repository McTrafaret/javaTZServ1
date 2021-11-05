package com.udalny.documents.paydocs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Inf_PAY")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfPay {

    @XmlElement(name = "INN_PAY")
    private String innPay;
    @XmlElement(name = "KPP_PAY")
    private String kppPay;
    @XmlElement(name = "CName_PAY")
    private String cnamePay;

    public String getInnPay() {
        return innPay;
    }

    public void setInnPay(String innPay) {
        this.innPay = innPay;
    }

    public String getKppPay() {
        return kppPay;
    }

    public void setKppPay(String kppPay) {
        this.kppPay = kppPay;
    }

    public String getCnamePay() {
        return cnamePay;
    }

    public void setCnamePay(String cnamePay) {
        this.cnamePay = cnamePay;
    }

    @Override
    public String toString() {
        return "InfPay{" +
                "innPay='" + innPay + '\'' +
                ", kppPay='" + kppPay + '\'' +
                ", cnamePay='" + cnamePay + '\'' +
                '}';
    }
}
