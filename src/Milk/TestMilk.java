package Milk;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Hashtable;

import org.junit.Test;

public class TestMilk {

	@Test
	public void test_getCapacity_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		int capacity = 1000;
		int result = milk.getCapacity();
		assertEquals(result, capacity);
	}

	@Test
	public void test_getCapacity_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		Integer capacity = 500;
		Integer result = milk.getCapacity();
		assertFalse(capacity.equals(result));
	}

	@Test
	public void test_getWarrant_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		String warranty = "1999-11-11";
		String result = milk.getWarrant();
		assertEquals(result, warranty);
	}

	@Test
	public void test_getWarrant_ReturnTrue_inCaseOfIncorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		String warranty = "2111-11-11";
		String result = milk.getWarrant();
		assertFalse(warranty.equals(result));
	}

	@Test
	public void test_getDripping_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1.0, 230, "test");
		Double dripping = 1.0;
		Double result = milk.getDripping();
		assertTrue(dripping.equals(result));
	}

	@Test
	public void test_getDripping_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1.0, 230, "test");
		Double dripping = 2.0;
		Double result = milk.getDripping();
		assertFalse(dripping.equals(result));
	}

	@Test
	public void test_getPrice_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		long price = 230;
		long result = milk.getPrice();
		assertEquals(result, price);
	}

	@Test
	public void test_getPrice_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		Long price = (long) 0;
		Long result = milk.getPrice();
		assertFalse(price.equals(result));
	}

	@Test
	public void test_getCompany_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		String company = "test";
		String result = milk.getCompany();
		assertEquals(result, company);
	}

	@Test
	public void test_getCompany_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		String company = "hello";
		String result = milk.getCompany();
		assertFalse(company.equals(result));
	}

	@Test
	public void test_getBarCode_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		Long barCode = (long) 1111;
		Long result = milk.getBarCode();
		assertEquals(result, barCode);
	}

	@Test
	public void test_getBarCode_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		Long price = (long) 1000;
		Long result = milk.getBarCode();
		assertFalse(price.equals(result));
	}

	@Test
	public void test_getWarrantyByBarCode_ReturnBarCode_inCaseOfEmptyHashTable() {
		Hashtable<Integer, Milk> testHashTable = new Hashtable<>();
		int barCode = 1111;
		String result = Milk.getWarrantyByBarCode(barCode, testHashTable);
		assertEquals(result, null);
	}

	@Test
	public void test_getWarrantyByBarCode_ReturnBarCode_inCaseOfCorrectBarCode() {
		Hashtable<Integer, Milk> testHashTable = new Hashtable<>();
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		testHashTable.put(1111, milk);
		int barCode = 1111;
		String result = Milk.getWarrantyByBarCode(barCode, testHashTable);
		assertEquals(result, milk.getWarrant());
	}

	@Test
	public void test_getWarrantyByBarCode_ReturnNull_inCaseOfIncorrectBarCode() {
		Hashtable<Integer, Milk> testHashTable = new Hashtable<>();
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		testHashTable.put(1111, milk);
		int barCode = 2222;
		String result = Milk.getWarrantyByBarCode(barCode, testHashTable);
		assertEquals(result, null);
	}

	@Test
	public void test_getWarrantyByBarCode_ReturnNull_inCaseOfMulitpleItemAndCorrectBarCode() {
		Hashtable<Integer, Milk> testHashTable = new Hashtable<>();
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		Milk milk2 = new Milk(2222, 500, "2017-11-11", 2, 260, "test2");
		testHashTable.put(1111, milk);
		testHashTable.put(2222, milk);
		int barCode = 2222;
		String result = Milk.getWarrantyByBarCode(barCode, testHashTable);
		assertEquals(result, milk.getWarrant());
	}

	@Test
	public void test_returnValueTesterForGetWarrantyByConsole_ReturnDate_inCaseOfDate() {
		String date = "2017-11-11";
		String result = Milk.returnValueTesterForGetWarrantyByConsole(date);
		assertEquals("2017-11-11", result);
	}

	/*
	 * @Test public void
	 * test_returnValueTesterForGetWarrantyByConsole_inCaseOfDate() { String
	 * date = null; String result =
	 * Milk.returnValueTesterForGetWarrantyByConsole(date);
	 * assertFalse(date.equals(result)); }
	 */

}
