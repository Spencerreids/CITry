package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntersectsTest {

	private Range Given;
	@BeforeEach
	void setUp() throws Exception {
		Given =  new Range(-10,10);
	}

	@AfterEach
	void tearDown() throws Exception{
		Given = null;
	}

	@Test
	void typicalUse() {
		assertAll(
				() -> assertTrue(Given.intersects(5, 6), "Range contains supplied range entirely"),
				() -> assertTrue(Given.intersects(0,15), "Range Intersects above"),
				() -> assertTrue(Given.intersects(-40,40),"Range is contained by supplied range"),
				() -> assertTrue(Given.intersects(-20,-9) , "Range intersects below"),
				() -> assertFalse(Given.intersects(13, 17), "Range is entirely smaller than supplied range"),
				() -> assertFalse(Given.intersects(-23, -17), "Range is entirely larger than supplied range"),
				() -> assertTrue(Given.intersects(5,5), "Range Intersects a single point range")
				);
	}
	
	@Test
	void incorrectUse() {
		assertTrue(Given.intersects(3, -3), "This is unintended behavior, and probably should throw an error, if agnostic to order should be true");
	}

}
