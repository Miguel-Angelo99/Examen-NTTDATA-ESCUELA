package com.nttdata.testing.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseMessage implements Question<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseMessage.class);

    public static Question<String> body() {
        return new ResponseMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        String responseBody = SerenityRest.lastResponse().asString();
        int statusCode = SerenityRest.lastResponse().getStatusCode();

        if (statusCode == 200) {
            return SerenityRest.lastResponse().jsonPath().getString("message");
        } else {
            // Log the error response
            System.err.println("Error response: " + responseBody);
            return "Error: " + responseBody;
        }
    }
}
