package com.udalny.documents.file.handler;

import com.udalny.documents.file.File;
import com.udalny.documents.file.FileType;
import com.udalny.xml.StringToDocumentConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class PayDocsFileHandler implements FileHandler {

    private static Logger logger  = LoggerFactory.getLogger(PayDocsFileHandler.class);
    private static final String TAG = "Inf_Pay_Doc";

    @Override
    public boolean probe(File f) {

        Document doc;
        try {
            doc = StringToDocumentConverter.convert(f.getContents());
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
