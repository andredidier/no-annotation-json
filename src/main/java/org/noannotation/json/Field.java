package org.noannotation.json;

public interface Field {
    Field change(Value value);

    <T extends Media<T>> T print(T media);

    interface Media<T extends Media<T>> {
        T name(String name);

        T value(Value value);
    }
}
