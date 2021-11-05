package org.noannotation.json;

public class AssertValueMedia implements Value.Media<AssertValueMedia> {

    private final Boolean booleanValue;
    private final String text;
    private final String[] printedElements;

    public AssertValueMedia(Boolean booleanValue, String text, String... printedElements) {
        this.booleanValue = booleanValue;
        this.text = text;
        this.printedElements = printedElements;
    }

    public AssertValueMedia() {
        this(null, null);
    }

    private String[] addNewElement(String name) {
        String[] newPrinted = new String[printedElements.length + 1];
        System.arraycopy(printedElements, 0, newPrinted, 0, printedElements.length);
        newPrinted[printedElements.length] = name;
        return newPrinted;
    }

    @Override
    public AssertValueMedia string(String text) {
        return new AssertValueMedia(booleanValue, text, addNewElement(String.format("string[%s]", text)));
    }

    @Override
    public AssertValueMedia bool(Boolean booleanValue) {
        return new AssertValueMedia(booleanValue, text, addNewElement(String.format("bool[%s]", booleanValue)));
    }

    public String string() {
        return text;
    }

    public String[] printedElements() {
        return printedElements;
    }
}
