package org.noannotation.json;

public interface Json {

    Object object();

    <T extends Media<T>> T print(T media);

    interface Media<T extends Media<T>> {

    }

    interface Object {
        Field field(String name);
    }
}
