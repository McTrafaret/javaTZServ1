package com.udalny.documents.file.handler;

import com.udalny.documents.file.File;

public interface FileHandler {

    boolean probe(File f);
    void handle(File f);

}
