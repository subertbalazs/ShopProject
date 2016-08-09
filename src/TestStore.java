import static org.junit.Assert.assertEquals;

import java.util.Hashtable;

import org.junit.Test;

public class TestStore {

	@Test
	public void test_isTHereAnyMilk_returnTrue_inCaseOfEmptyHashTable() {
		Hashtable testHashTable = new Hashtable<>();
		boolean result = Store.isThereAnyMilk(testHashTable);
		assertEquals(result, true);
	}

	@Test
	public void test_isTHereAnyMilk_returnFalse_inCaseOfHashTableWithOneItem() {
		Hashtable testHashTable = new Hashtable<>();
		testHashTable.put(1, "one");
		boolean result = Store.isThereAnyMilk(testHashTable);
		assertEquals(result, false);
	}

	@Test
	public void test_buyMilk_returnFalse_inCaseOfEmptyHashTabl() {
		Hashtable testHashTable = new Hashtable<>();
		int barCode = 1;
		boolean result = Store.buyMilk(testHashTable, barCode);
		assertEquals(result, false);
	}

	@Test
	public void test_buyMilk_returnFalse_inCaseOfOneItemWithWrongKey() {
		Hashtable testHashTable = new Hashtable<>();
		testHashTable.put(1, "one");
		int barCode = 2;
		boolean result = Store.buyMilk(testHashTable, barCode);
		assertEquals(result, false);
	}
	
	@Test
	public void test_buyMilk_returnTrue_inCaseOfOneItemWithCorrectKey() {
		Hashtable testHashTable = new Hashtable<>();
		testHashTable.put(1, "one");
		int barCode = 1;
		boolean result = Store.buyMilk(testHashTable, barCode);
		assertEquals(result, true);
	}

	@Test
	public void test_buyMilk_returnTrue_inCaseOfMultipleItemWithCorrectKey() {
		Hashtable testHashTable = new Hashtable<>();
		testHashTable.put(1, "one");
		testHashTable.put(2, "one");
		int barCode = 2;
		boolean result = Store.buyMilk(testHashTable, barCode);
		assertEquals(result, true);
	}

	@Test
	public void test_addMilkToMilkBar_returnTrue_inCaseOfOneObject() {
		Hashtable testHashTable = new Hashtable<>();
		Milk milk = new Milk(1111, 1000, "2017-11-11", 1, 280, "testCompany");
		boolean result = Store.addMilkToMilkBar(milk, testHashTable);
		assertEquals(result, true);
		;
	}
}
