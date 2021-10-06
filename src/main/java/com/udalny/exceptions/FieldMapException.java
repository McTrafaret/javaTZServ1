package com.udalny.exceptions;

import java.lang.reflect.Field;

public class FieldMapException
        extends ReflectiveOperationException {

    final Field f;
    final String value;

    public FieldMapException(String message) {
       super(message);
       this.f = null;
       this.value = null;
    }

    public FieldMapException(String message, Throwable cause) {
        super(message, cause);
        this.f = null;
        this.value = null;
    }

    public FieldMapException(Field f, String value) {
        super(String.format("Couldn't map value %s to field %s(%s)", value, f.getName(), f.getType().toString()));
        this.f = f;
        this.value = value;
    }

    public FieldMapException(Field f, String value, Throwable cause) {
        super(String.format("Couldn't map value %s to field %s(%s)%nCause: %s", value, f.getName(),
                            f.getType().toString(), cause.toString()));
        this.f = f;
        this.value = value;
    }
}
