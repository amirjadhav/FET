package com.cybage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AppTest {

	@Tag("PROD")    //Target as production
	@Test
	public void test1() {
		assertEquals(1, 1);
	}
	@Tag("DEV")  //Target as development
	@Test
	public void test2() {
		assertEquals(10, 10);
	}
}