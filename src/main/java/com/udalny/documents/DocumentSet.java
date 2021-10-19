package com.udalny.documents;

import com.udalny.documents.paydocs.PayDocs;
import com.udalny.documents.report.Report;
import com.udalny.exceptions.DocumentSetException;

import java.util.List;

public class DocumentSet {
    private Report report;
    private PayDocs paydocs;
    private static final String CAST_ERROR = "One of the documents is not valid PayDocs or Report document.";

    //как масштабируем для 3, 4, 5 ?
    public DocumentSet(ServerDocument a, ServerDocument b)
            throws ClassCastException {
        if (a instanceof Report) {
            report = (Report) a;
            if (b instanceof PayDocs) {
                paydocs = (PayDocs) b;
            } else {
                throw new ClassCastException(CAST_ERROR);
            }
        } else if (a instanceof PayDocs) {
            paydocs = (PayDocs) a;
            if (b instanceof Report) {
                report = (Report) b;
            } else {
                throw new ClassCastException(CAST_ERROR);
            }
        } else {
            throw new ClassCastException(CAST_ERROR);
        }
    }

    public DocumentSet(Report report, PayDocs paydocs) {
        this.report = report;
        this.paydocs = paydocs;
    }

    public DocumentSet(List<ServerDocument> list)
            throws DocumentSetException {
        for (ServerDocument doc : list) {
            if (doc.getClass() == Report.class) {
                if (this.report == null) {
                    this.report = (Report) doc;
                } else {
                    throw new DocumentSetException("Report appears several times in list, aborting...");
                }
            } else {
                if (this.paydocs == null) {
                    this.paydocs = (PayDocs) doc;
                } else {
                    throw new DocumentSetException("PayDocs appears several times in list, aborting...");
                }
            }
        }
    }

    public Report getReport() {
        return report;
    }

    public PayDocs getPayDocs() {
        return paydocs;
    }
}
