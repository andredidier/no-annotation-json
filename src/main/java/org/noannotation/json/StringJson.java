package org.noannotation.json;

import java.util.Map;

public class StringJson implements Json {
    private final String original;
    private final int start;
    private final int end;

    public StringJson(String original, int start, int end) {
        this.original = original;
        this.start = start;
        this.end = end;
    }

    public StringJson(String original) {
        this(original, 0, original.length());
    }

    @Override
    public Object object() {
        return new StringObject(new StringJson(original,
                                               findNonSpaceAfterOpening(start),
                                               findNonSpaceBeforeClosing(end)));
    }

    private boolean nonSpace(char c) {
        return c != ' ' && c != '\t' && c != '\n' && c != '\r';
    }

    private int findNonSpaceBeforeClosing(int end) {
        boolean foundBracket = false;
        boolean foundNonSpace = false;
        for (int i = end - 1; i >= 0; i--) {
            char c = original.charAt(i);
            if (c == '}' && !foundBracket) {
                foundBracket = true;
            } else if (nonSpace(c)) {
                foundNonSpace = true;
            }
            if (foundBracket && foundNonSpace) {
                return i;
            }
        }
        throw new StringDoesNotMatchObjectException(original, end);
    }

    private int findNonSpaceAfterOpening(int start) {
        boolean foundBracket = false;
        boolean foundNonSpace = false;

        for (int i = start; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c == '{' && !foundBracket) {
                foundBracket = true;
            } else if (nonSpace(c)) {
                foundNonSpace = true;
            }
            if (foundBracket && foundNonSpace) {
                return i;
            }
        }
        throw new StringDoesNotMatchObjectException(original, start);
    }

    @Override
    public <T extends Media<T>> T print(T media) {
        return media;
    }

    private static class StringObject implements Json.Object {
        private final StringJson inner;

        private StringObject(StringJson inner) {
            this.inner = inner;
        }

        @Override
        public Field field(String name) {
            return null;
        }
    }

    private static class ObjectField implements Field {

        @Override
        public Field change(Value value) {
            return null;
        }

        @Override
        public <T extends Media<T>> T print(T media) {
            return null;
        }
    }

    private static class StringDoesNotMatchObjectException extends IllegalArgumentException {
        public StringDoesNotMatchObjectException(String original, int start) {
            super(String.format("index = %d, json = %s", start, original));
        }
    }
}
