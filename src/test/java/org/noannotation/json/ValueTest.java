package org.noannotation.json;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValueTest {

    private ValueModel model;

    @BeforeEach
    void setup() {
        model = new ValueModel();
    }

    @Test
    void givenStringValue_printsString() {
        String text = "my shiny text";
        model.given().string(text).then().stringMatches(text);
    }

    @Test
    void givenEmptyValue_printsNothing() {
        model.given().emptyValue().then().nothingPrinted();
    }
}
