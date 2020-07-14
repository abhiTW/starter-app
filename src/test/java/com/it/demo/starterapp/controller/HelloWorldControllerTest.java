package com.it.demo.starterapp.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldControllerTest {
    @Test
    void shouldReturnHelloWorld() {
        assertEquals("Hello World", new HelloWorldController().hello());
    }
}