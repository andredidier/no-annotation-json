package org.noannotation.json;

public class ValueField implements Field {
    private final Value value;

    public ValueField(Value value) {
        this.value = value;
    }

    public static ValueField empty() {
        return new ValueField(EmptyValue.instance());
    }

    @Override
    public Field change(Value value) {
        return new ValueField(value);
    }

    @Override
    public <T extends Media<T>> T print(T media) {
        return media.value(value);
    }
}
