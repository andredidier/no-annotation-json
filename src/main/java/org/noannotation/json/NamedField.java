package org.noannotation.json;

public class NamedField implements Field {
    private final String name;
    private final Field inner;

    public NamedField(String name, Field inner) {
        this.name = name;
        this.inner = inner;
    }

    @Override
    public Field change(Value value) {
        return new NamedField(name, inner.change(value));
    }

    @Override
    public <T extends Media<T>> T print(T media) {
        return inner.print(media.name(name));
    }
}
