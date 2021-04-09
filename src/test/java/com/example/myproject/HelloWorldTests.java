package com.example.myproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloWorldTests {

	HelloWorld hw= new HelloWorld();

	@Test
	void test() {
        assertEquals(25,hw.square(25));
	}
	


}
