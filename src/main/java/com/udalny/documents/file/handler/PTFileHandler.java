package com.udalny.documents.file.handler;

import com.udalny.documents.file.File;
import com.udalny.documents.file.FileType;
import com.udalny.xml.PTParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTFileHandler
        implements FileHandler {

    @Autowired
    private PTParser parser;

    @Override
    public boolean probe(File f) {
        return parser.applied(f.getContents());
    }

    @Override
    public void handle(File f) {
        f.setType(FileType.PT);
    }
}
