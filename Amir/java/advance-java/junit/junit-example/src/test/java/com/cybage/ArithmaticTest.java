package com.cybage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

class ArithmeticTest {

	@BeforeAll // it will execute at the start of unit testing
	static void setup() {
		System.out.println("this will execute at the start of testing");
	}

	@BeforeEach
	void beforeEveryUnitTestCase() {
		System.out.println("it will execute before every unit test case");
	}

	@AfterEach
	void afterEveryUnitTestCase() {
		System.out.println("it will execute after every unit test case");
	}

	Arithmatic arithmetic = new Arithmatic();

	@Test // @Test --> we are writing this method for unit testing...
	void testAdd() {
		int actual = arithmetic.add(10, 20);
		int expected = 30;

		assertEquals(expected, actual); // testing for correct result
		assertEquals(0, arithmetic.add(0, 0));
		// assertEquals(-540, arithmetic.add(-10, -20));
		// assertEquals(567510, arithmetic.add(-10, 20));
	}
	@RepeatedTest(10)
	@Test // @Test --> we are writing this method for unit testing...
	void testSub() {
		int[] a =new int[] {12,12};
		int actual = arithmetic.sub(10, 20);
		int expected = -10;
		assertArrayEquals(new int[] { 10, 20 }, new int[] { 10, 20 });
		assertEquals(expected, actual); // testing for correct result
		assertEquals(0, arithmetic.sub(0, 0));
		assertEquals(3450, arithmetic.sub(-10, -20));
		assertEquals(-567530, arithmetic.sub(-10, 20));
	}
	@Test
	void testDiv() {
		assertThrows(ArithmeticException.class, ()->arithmetic.div(10,10));
	}

	@Disabled
	@DisplayName("method for testing java version")
	@Test
	@EnabledOnJre(JRE.JAVA_8)
	void testJre() {
		System.out.println("JRE 8");
	}
	
	@AfterAll
	static void finish() {
		System.out.println("we have finished all test case");
	}
}