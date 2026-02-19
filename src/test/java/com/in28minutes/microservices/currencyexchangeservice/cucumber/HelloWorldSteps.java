package com.in28minutes.microservices.currencyexchangeservice.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.in28minutes.microservices.currencyexchangeservice.HelloWorld;

public class HelloWorldSteps {

    private HelloWorld helloWorld = new HelloWorld();

    private String name = "";
    private String output = "";

    @Given("A String name {string}")
    public void givenInput(String name) {
        this.name = name;
    }

    @When("sayHello method of HelloWorld.java is called")
    public void whenBusinessLogicCalled() {
        output = helloWorld.sayHello(name);
    }

    @Then("It should return {string}")
    public void thenCheckOutput(String response) {
        assertEquals(response, output);
    }
}
