package com.udalny.upload;

public interface Uploader<T> {

    void upload(T what);

}
