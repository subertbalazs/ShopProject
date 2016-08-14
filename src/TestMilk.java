import static org.junit.Assert.assertEquals;

import java.util.Hashtable;

import org.junit.Test;

public class TestMilk {

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
