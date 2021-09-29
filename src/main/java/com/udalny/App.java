package com.udalny;

import com.udalny.documents.paydocs.PayDocs;
import com.udalny.xml.dom.XMLDomParserPayDocs;
import org.apache.log4j.Logger;

public class App {

    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            logger.error("Xml file not specified.");
            return;
        }

        try {
            XMLDomParserPayDocs parser = new XMLDomParserPayDocs(args[0]);
            PayDocs report = parser.parse();
            logger.info(report);
            logger.info(report.getDocs().size());
        } catch (Exception ex) {
            logger.error(ex);
        }

    }
}
