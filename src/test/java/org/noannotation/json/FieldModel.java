package org.noannotation.json;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FieldModel {

    private final Field field;

    public FieldModel(Field field) {
        this.field = field;
    }

    public FieldModel() {
        this(ValueField.empty());
    }

    private FieldModel name(String name) {
        return new FieldModel(new NamedField(name, field));
    }

    private FieldModel value(Value value) {
        return new FieldModel(field.change(value));
    }

    private FieldModel changesTo(Value value) {
        return value(value);
    }

    private void assertNameIs(String name) {
        AssertFieldMedia media = field.print(new AssertFieldMedia());
        assertThat(media.name(), is(name));
    }

    private void assertValueIs(Value value) {
        AssertFieldMedia media = field.print(new AssertFieldMedia());
        assertThat(media.value(), is(value));
    }

    public Given given() {
        return new Given(this);
    }

    public static class Given {
        private final FieldModel model;

        public Given(FieldModel model) {
            this.model = model;
        }

        public Given name(String name) {
            return new Given(model.name(name));
        }

        public Given value(Value value) {
            return new Given(model.value(value));
        }

        public Then then() {
            return new Then(model);
        }

        public Given changesTo(Value value) {
            return new Given(model.changesTo(value));
        }
    }

    public static class Then {
        private final FieldModel model;

        public Then(FieldModel model) {
            this.model = model;
        }

        public void nameEquals(String name) {
            model.assertNameIs(name);
        }

        public void valueEquals(Value value) {
            model.assertValueIs(value);
        }
    }

}
