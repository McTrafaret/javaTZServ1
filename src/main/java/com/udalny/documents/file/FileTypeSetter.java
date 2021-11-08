package com.udalny.documents.file;

import com.udalny.documents.file.handler.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileTypeSetter {

    @Autowired
    private List<FileHandler> handlers;

    public void set(File file) {
        for (FileHandler handler : handlers) {
            if (handler.probe(file)) {
                handler.handle(file);
            }
        }
    }

    public void setAll(List<File> files) {
        for (File f : files) {
            set(f);
        }
    }

}
