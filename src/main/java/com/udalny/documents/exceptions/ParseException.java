package com.udalny.documents.exceptions;

public class ParseException
        extends Exception {

    final String filename;

    public ParseException() {
        super("Failed to parse document");
        this.filename = null;
    }

    public ParseException(String message) {
        super(message);
        this.filename = null;
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
        this.filename = null;
    }

    public ParseException(String filename, String cause) {
        super(String.format("Can't parse file %s. Cause: %s", filename, cause));
        this.filename = filename;
    }
}
