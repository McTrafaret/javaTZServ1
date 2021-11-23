package com.udalny.documents;

import java.math.BigDecimal;
import java.util.Date;

public class PTDocument {

    private String guidReceived;
    private String numReceived;
    private Date dateReceived;
    private String senderOrganizationName;
    private BigDecimal amountSend;
    private String guidSend;
    private String typeSend;
    private String typeNameSend;
    private String numSend;
    private Date dateSend;
    private String receiverOrganizationName;
    private String rejectionReason;

    public String getGuidReceived() {
        return guidReceived;
    }

    public void setGuidReceived(String guidReceived) {
        this.guidReceived = guidReceived;
    }

    public String getNumReceived() {
        return numReceived;
    }

    public void setNumReceived(String numReceived) {
        this.numReceived = numReceived;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getSenderOrganizationName() {
        return senderOrganizationName;
    }

    public void setSenderOrganizationName(String senderOrganizationName) {
        this.senderOrganizationName = senderOrganizationName;
    }

    public BigDecimal getAmountSend() {
        return amountSend;
    }

    public void setAmountSend(BigDecimal amountSend) {
        this.amountSend = amountSend;
    }

    public String getGuidSend() {
        return guidSend;
    }

    public void setGuidSend(String guidSend) {
        this.guidSend = guidSend;
    }

    public String getTypeSend() {
        return typeSend;
    }

    public void setTypeSend(String typeSend) {
        this.typeSend = typeSend;
    }

    public String getTypeNameSend() {
        return typeNameSend;
    }

    public void setTypeNameSend(String typeNameSend) {
        this.typeNameSend = typeNameSend;
    }

    public String getNumSend() {
        return numSend;
    }

    public void setNumSend(String numSend) {
        this.numSend = numSend;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public String getReceiverOrganizationName() {
        return receiverOrganizationName;
    }

    public void setReceiverOrganizationName(String receiverOrganizationName) {
        this.receiverOrganizationName = receiverOrganizationName;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    @Override
    public String toString() {
        return "PTDocument{" +
                "guidReceived='" + guidReceived + '\'' +
                ", numReceived='" + numReceived + '\'' +
                ", dateReceived=" + dateReceived +
                ", senderOrganizationName='" + senderOrganizationName + '\'' +
                ", amountSend=" + amountSend +
                ", guidSend='" + guidSend + '\'' +
                ", typeSend='" + typeSend + '\'' +
                ", nameSend='" + typeNameSend + '\'' +
                ", numSend='" + numSend + '\'' +
                ", dateSend=" + dateSend +
                ", receiverOrganizationName='" + receiverOrganizationName + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}
