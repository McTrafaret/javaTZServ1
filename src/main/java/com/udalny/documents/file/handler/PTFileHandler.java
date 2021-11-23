package com.udalny.documents.file.handler;

import com.udalny.documents.file.File;

public class PTFileHandler
        implements FileHandler {

    @Override
    public boolean probe(File f) {
        return false;
    }

    @Override
    public void handle(File f) {

    }
}
