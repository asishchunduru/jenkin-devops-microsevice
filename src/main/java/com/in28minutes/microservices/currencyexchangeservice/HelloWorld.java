package com.in28minutes.microservices.currencyexchangeservice;

public class HelloWorld {

    public String sayHello(String name) {

        if (name == null || name.trim().isEmpty()) {
            return "Hello Guest";
        }

        return "Hello " + name.trim();
    }
}
