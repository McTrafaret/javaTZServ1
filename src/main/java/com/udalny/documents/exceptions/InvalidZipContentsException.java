package com.udalny.documents.exceptions;

public class InvalidZipContentsException
        extends Exception {

    public InvalidZipContentsException(String message) {
        super(message);
    }

    public InvalidZipContentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidZipContentsException() {
        super("Invalid contents of zip file, should have at least two documents: PayDocs.xml and Report.xml");
    }
}
