package org.noannotation.json;

public class EmptyValue implements Value {
    public static Value instance() {
        return new EmptyValue();
    }

    @Override
    public <T extends Media<T>> T print(T media) {
        return media;
    }

    @Override
    @ExcludeFromJacocoGeneratedReport
    public String toString() {
        return "EmptyValue{}";
    }
}
