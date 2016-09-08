package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import products.Cheese;

public class TestCheese {

	@Test
	public void test_getDripping_ReturnTrue_inCaseOfCorrectValue() {
		Cheese cheese = new Cheese(1111, 10.0, "1999-11-11", 1.0, "test");
		Double dripping = 1.0;
		Double result = cheese.getDripping();
		assertTrue(dripping.equals(result));
	}

	@Test
	public void test_getWeight_ReturnFalse_inCaseOfIncorrectValue() {
		Cheese cheese = new Cheese(1111, 10.0, "1999-11-11", 1.0, "test");
		Double dripping = 2.0;
		Double result = cheese.getWeight();
		assertFalse(dripping.equals(result));
	}

	@Test
	public void test_getWeigth_ReturnTrue_inCaseOfCorrectValue() {
		Cheese cheese = new Cheese(1111, 10.0, "1999-11-11", 1.0, "test");
		Double dripping = 10.0;
		Double result = cheese.getWeight();
		assertTrue(dripping.equals(result));
	}

	@Test
	public void test_getDripping_ReturnFalse_inCaseOfIncorrectValue() {
		Cheese cheese = new Cheese(1111, 10.0, "1999-11-11", 1.0, "test");
		Double dripping = 2.0;
		Double result = cheese.getDripping();
		assertFalse(dripping.equals(result));
	}

}
