package com.udalny.documents.file.handler;

import com.udalny.documents.file.File;
import com.udalny.documents.file.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@Service
public class PayDocsFileHandler implements FileHandler {

    private static Logger logger  = LoggerFactory.getLogger(PayDocsFileHandler.class);
    private static final String TAG = "Inf_Pay_Doc";

    @Override
    public boolean probe(File f) {

        Document doc;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(f.getContents())));
        }
        catch (Exception ex) {
            logger.warn("Failed to parse xml in " + f.getName(), ex);
            return false;
        }
        return doc.getDocumentElement().getTagName().equals(TAG);
    }

    @Override
    public void handle(File f) {
        f.setType(FileType.PAYDOCS);
    }
}
