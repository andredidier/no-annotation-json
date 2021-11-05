package org.noannotation.json;

public class AssertFieldMedia implements Field.Media<AssertFieldMedia> {

    private final String name;
    private final Value value;

    public AssertFieldMedia(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    public AssertFieldMedia() {
        this(null, null);
    }

    @Override
    public AssertFieldMedia name(String name) {
        return new AssertFieldMedia(name, value);
    }

    @Override
    public AssertFieldMedia value(Value value) {
        return new AssertFieldMedia(name, value);
    }

    public String name() {
        return name;
    }

    public Value value() {
        return value;
    }
}
