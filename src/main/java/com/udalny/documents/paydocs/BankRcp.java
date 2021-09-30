package com.udalny.documents.paydocs;

import com.udalny.util.ObjectMapper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "Bank_RCP")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankRcp {
    private String BS_PAY;
    private String BIC_PAY;
    private String BS_KS_PAY;

    public BankRcp() {
    }

    public BankRcp(Map<String, Object> map) {
        ObjectMapper.map(this, map);
    }

    public String getBS_PAY() {
        return BS_PAY;
    }

    public String getBIC_PAY() {
        return BIC_PAY;
    }

    public String getBS_KS_PAY() {
        return BS_KS_PAY;
    }

    @Override
    public String toString() {
        return "BankPay{" +
                "BS_PAY='" + BS_PAY + '\'' +
                ", BIC_PAY='" + BIC_PAY + '\'' +
                ", BS_KS_PAY='" + BS_KS_PAY + '\'' +
                '}';
    }
}
