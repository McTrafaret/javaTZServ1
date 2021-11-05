package com.udalny.documents.file;

public class File {

    private String name;
    private String contents;
    private FileType type;

    public File(String name, String contents) {
        this.name = name;
        this.contents = contents;
        this.type = FileType.UNKNOWN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", contents='" + contents + '\'' +
                ", type=" + type +
                '}';
    }
}
