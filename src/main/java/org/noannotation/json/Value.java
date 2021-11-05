package org.noannotation.json;

public interface Value {

    <T extends Media<T>> T print(T media);

    interface Media<T extends Media<T>> {
        T string(String text);

        T bool(Boolean value);
    }
}
