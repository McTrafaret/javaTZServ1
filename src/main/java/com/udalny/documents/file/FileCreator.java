package com.udalny.documents.file;

import com.udalny.documents.file.handler.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileCreator {

    private List<FileHandler> handlers;

    @Autowired
    public FileCreator(List<FileHandler> handlers) {
        this.handlers = handlers;
    }

    public File create(String filename, String contents) {
        File file = new File(filename, contents);
        for (FileHandler handler : handlers) {
            if (handler.probe(file)) {
                handler.handle(file);
            }
        }
        return file;
    }

}
