package org.noannotation.json;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FieldTest {

    private FieldModel model;

    @BeforeEach
    void setup() {
        model = new FieldModel();
    }

    @Test
    void initializeWithName_printsName() {
        String name = "my shiny name";
        model.given().name(name).then().nameEquals(name);
    }

    @Test
    void initializeWithValue_printsValue() {
        Value value = StringValue.of("my shiny value");
        model.given().value(value).then().valueEquals(value);
    }

    @Test
    void initializeWithNameAndValue_printsName() {
        String name = "my shiny name";
        Value value = StringValue.of("my shiny value");
        model.given().name(name).value(value).then().nameEquals(name);
    }

    @Test
    void initializeWithNameAndValue_printsValue() {
        String name = "my shiny name";
        Value value = StringValue.of("my shiny value");
        model.given().name(name).value(value).then().valueEquals(value);
    }

    @Test
    void initializeWithValueAndName_printsName() {
        String name = "my shiny name";
        Value value = StringValue.of("my shiny value");
        model.given().value(value).name(name).then().nameEquals(name);
    }

    @Test
    void initializeWithValueAndName_printsValue() {
        String name = "my shiny name";
        Value value = StringValue.of("my shiny value");
        model.given().value(value).name(name).then().valueEquals(value);
    }

    @Test
    void changeValue_printsNewValue() {
        Value value = StringValue.of("initial value");
        Value newValue = StringValue.of("second value");
        model.given()
             .value(value)
             .changesTo(newValue)
             .then()
             .valueEquals(newValue);
    }
}
