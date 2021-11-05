package org.noannotation.json;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValueModel {

    private final Value value;

    public ValueModel(Value value) {
        this.value = value;
    }

    public ValueModel() {
        this(EmptyValue.instance());
    }

    public Given given() {
        return new Given(this);
    }

    private ValueModel string(String text) {
        return new ValueModel(StringValue.of(text));
    }

    private ValueModel emptyValue() {
        return new ValueModel(EmptyValue.instance());
    }

    private void matchesString(String text) {
        AssertValueMedia actual = value.print(new AssertValueMedia());
        assertThat(actual.string(), is(text));
    }

    private void nothingPrinted() {
        AssertValueMedia actual = value.print(new AssertValueMedia());
        assertThat(actual.printedElements(), is(new String[0]));
    }

    public static class Given {
        private final ValueModel model;

        public Given(ValueModel model) {
            this.model = model;
        }

        public Given string(String text) {
            return new Given(model.string(text));
        }

        public Then then() {
            return new Then(model);
        }

        public Given emptyValue() {
            return new Given(model.emptyValue());
        }
    }

    public static class Then {
        private final ValueModel model;

        public Then(ValueModel model) {
            this.model = model;
        }

        public void stringMatches(String text) {
            model.matchesString(text);
        }

        public void nothingPrinted() {
            model.nothingPrinted();
        }
    }
}
