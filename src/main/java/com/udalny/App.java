package com.udalny;

import com.udalny.documents.SummaryDocument;
import com.udalny.documents.SummaryDocumentFactory;
import com.udalny.documents.ZipHandler;
import org.apache.log4j.Logger;

import java.util.List;

public class App {

    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            logger.error("Xml file not specified.");
            return;
        }

        try {
            ZipHandler zipHandler = new ZipHandler(args[0]);
            List<SummaryDocument> list = SummaryDocumentFactory.createListOfSummaryDocuments(zipHandler.getDocuments());
            logger.info(list);
        } catch (Exception ex) {
            logger.error(ex);
        }

    }
}
