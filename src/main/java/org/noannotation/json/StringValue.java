package org.noannotation.json;

public class StringValue implements Value {
    private final String text;

    public StringValue(String text) {
        this.text = text;
    }

    public static StringValue of(String text) {
        return new StringValue(text);
    }

    @Override
    public <T extends Media<T>> T print(T media) {
        return media.string(text);
    }

    @Override
    @ExcludeFromJacocoGeneratedReport
    public String toString() {
        return String.format("StringValue{text='%s'}", text);
    }
}
