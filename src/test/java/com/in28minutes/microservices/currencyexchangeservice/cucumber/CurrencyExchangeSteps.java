package com.in28minutes.microservices.currencyexchangeservice.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyExchangeSteps {

    float output = 0f;

    @Given("conversion rate for {string} to {string}")
    public void conversion_rate_for_from_to(String from, String to) {

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        String url = "http://localhost:8000/currency-exchange/from/"
                + from + "/to/" + to;

        Response response = when().get(url);

        response.then().statusCode(200);

        output = response.then()
                .extract()
                .path("conversionMultiple");
    }

    @When("the system is asked to provide the conversion rate")
    public void the_system_is_asked_to_provide_the_conversion_rate() {
        // No action needed
    }

    @Then("It should output {float}")
    public void thenCheckOutput(float expected) {
        assertEquals(expected, output, 0.5);
    }
}
