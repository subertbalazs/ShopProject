package Store;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Hashtable;

import org.junit.Test;

import Milk.Milk;

public class TestStore {

	@Test
	public void test_getName_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		String name = "TestBolt";
		String result = store.getName();
		assertEquals(result, name);
	}

	@Test
	public void test_getName_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		String name = "Boltocska";
		String result = store.getName();
		assertFalse(name.equals(result));
	}

	@Test
	public void test_getAddress_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		String address = "Miskolc";
		String result = store.getAddress();
		assertEquals(result, address);
	}

	@Test
	public void test_getOwner_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		String owner = "Nem Boss";
		String result = store.getOwner();
		assertFalse(owner.equals(result));
	}

	@Test
	public void test_getOwner_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		String owner = "The Boss";
		String result = store.getOwner();
		assertEquals(result, owner);
	}

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
		boolean result = Store.buyMilk(barCode, testHashTable);
		assertEquals(result, false);
	}

	@Test
	public void test_buyMilk_returnFalse_inCaseOfOneItemWithWrongKey() {
		Hashtable<Integer, Milk> testHashTable = new Hashtable<>();
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		testHashTable.put(1, milk);
		int barCode = 2;
		boolean result = Store.buyMilk(barCode, testHashTable);
		assertEquals(result, false);
	}
	
	@Test
	public void test_buyMilk_returnTrue_inCaseOfOneItemWithCorrectKey() {
		Hashtable<Integer, Milk> testHashTable = new Hashtable<>();
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		testHashTable.put(1111, milk);
		int barCode = 1111;
		boolean result = Store.buyMilk(barCode, testHashTable);
		assertEquals(result, true);
	}

	@Test
	public void test_buyMilk_returnTrue_inCaseOfMultipleItemWithCorrectKey() {
		Hashtable<Integer, Milk> testHashTable = new Hashtable<>();
		Milk milk = new Milk(1111, 1000, "1999-11-11", 1, 230, "test");
		Milk milk2 = new Milk(2222, 500, "2012-11-11", 1, 240, "test2");
		testHashTable.put(1111, milk);
		testHashTable.put(2222, milk2);
		int barCode = 2222;
		boolean result = Store.buyMilk(barCode, testHashTable);
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

