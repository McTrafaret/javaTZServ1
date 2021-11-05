package com.udalny.documents.packet;

import com.udalny.documents.file.File;

import java.util.LinkedList;
import java.util.List;

public class Packet {

    private File mainDocument;
    private List<File> secondaryDocuments;

    public Packet() {
        secondaryDocuments = new LinkedList<>();
    }

    public Packet(File main) {
        this.mainDocument = main;
        secondaryDocuments = new LinkedList<>();
    }

    public void addDocument(File document) {
        secondaryDocuments.add(document);
    }

    public File getMainDocument() {
        return mainDocument;
    }

    public void setMainDocument(File mainDocument) {
        this.mainDocument = mainDocument;
    }

    public List<File> getSecondaryDocuments() {
        return secondaryDocuments;
    }

    public void setSecondaryDocuments(List<File> secondaryDocuments) {
        this.secondaryDocuments = secondaryDocuments;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "mainDocument=" + mainDocument +
                ", secondaryDocuments=" + secondaryDocuments +
                '}';
    }
}
