package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import products.LongLifeMilk;
import products.Milk;

public class TestMilk {

	@Test
	public void test_getCapacity_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		int capacity = 1000;
		int result = milk.getCapacity();
		assertEquals(result, capacity);
	}
	@Test
	public void test_getCapacity_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		int capacity = 500;
		int result = milk.getCapacity();
		assertFalse(capacity == result);
	}

	@Test
	public void test_getDripping_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1.0, "test");
		Double dripping = 1.0;
		Double result = milk.getDripping();
		assertTrue(dripping.equals(result));
	}
	@Test
	public void test_getDripping_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1.0, "test");
		Double dripping = 2.0;
		Double result = milk.getDripping();
		assertFalse(dripping.equals(result));
	}
	@Test
	public void test_getCompany_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		String company = "test";
		String result = milk.getCompany();
		assertEquals(result, company);
	}
	@Test
	public void test_getCompany_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		String company = "hello";
		String result = milk.getCompany();
		assertFalse(company.equals(result));
	}

	/*
	 * @Test public void
	 * test_returnValueTesterForGetWarrantyByConsole_inCaseOfDate() { String
	 * date = null; String result =
	 * Milk.returnValueTesterForGetWarrantyByConsole(date);
	 * assertFalse(date.equals(result)); }
	 */

}
