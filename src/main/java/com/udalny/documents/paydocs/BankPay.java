package com.udalny.documents.paydocs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bank_PAY")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankPay {

    @XmlElement(name = "BS_PAY")
    private String bsPay;
    @XmlElement(name = "BIC_PAY")
    private String bicPay;
    @XmlElement(name = "BS_KS_PAY")
    private String bsKsPay;

    public String getBsPay() {
        return bsPay;
    }

    public void setBsPay(String bsPay) {
        this.bsPay = bsPay;
    }

    public String getBicPay() {
        return bicPay;
    }

    public void setBicPay(String bicPay) {
        this.bicPay = bicPay;
    }

    public String getBsKsPay() {
        return bsKsPay;
    }

    public void setBsKsPay(String bsKsPay) {
        this.bsKsPay = bsKsPay;
    }

    @Override
    public String toString() {
        return "BankPay{" +
                "bsPay='" + bsPay + '\'' +
                ", bicPay='" + bicPay + '\'' +
                ", bsKsPay='" + bsKsPay + '\'' +
                '}';
    }
}
