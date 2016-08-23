package Store;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Hashtable;

import org.junit.Test;

import Milk.LongLifeMilk;
import Milk.Milk;
import Products.Food;
import Store.Store.StoreEntry;

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
		Hashtable<Integer, StoreEntry> testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		StoreEntry storeEntry1 = store.new StoreEntry(milk, 2, 230);
		testHashTable.put(1, storeEntry1);
		int barCode = 2;
		boolean result = Store.buyMilk(barCode, testHashTable);
		assertEquals(result, false);
	}
	@Test
	public void test_buyMilk_returnTrue_inCaseOfOneItemWithCorrectKey() {
		Hashtable<Integer, StoreEntry> testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		StoreEntry storeEntry1 = store.new StoreEntry(milk, 2, 230);
		testHashTable.put(1111, storeEntry1);
		int barCode = 1111;
		boolean result = Store.buyMilk(barCode, testHashTable);
		assertEquals(result, true);
	}
	@Test
	public void test_buyMilk_returnTrue_inCaseOfMultipleItemWithCorrectKey() {
		Hashtable<Integer, StoreEntry> testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		Milk milk2 = new LongLifeMilk(2222, 500, "2012-11-11", 1, "test2");
		StoreEntry storeEntry1 = store.new StoreEntry(milk, 1, 230);
		StoreEntry storeEntry2 = store.new StoreEntry(milk2, 2, 240);
		testHashTable.put(1111, storeEntry1);
		testHashTable.put(2222, storeEntry2);
		int barCode = 2222;
		boolean result = Store.buyMilk(barCode, testHashTable);
		assertEquals(result, true);
	}
	@Test
	public void test_addMilkToMilkBar_returnTrue_inCaseOfOneObject() {
		Hashtable testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "2017-11-11", 1, "testCompany");
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		boolean result = Store.addNewProductToStore(storeEntry, testHashTable);
		assertEquals(result, true);
		;
	}
	@Test
	public void test_getMilk_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		Food result = storeEntry.getMilk();
		assertEquals(result, milk);
	}
	@Test
	public void test_getPrice_ReturnTure_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		long price = 230;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		long result = storeEntry.getPrice();
		assertEquals(result, price);
	}
	@Test
	public void test_getMilk_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		long price = 280;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		long result = storeEntry.getPrice();
		assertFalse(price == result);
	}
	@Test
	public void test_getQuantity_ReturnTure_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		int price = 1;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		int result = storeEntry.getQuantity();
		assertEquals(result, price);
	}
	@Test
	public void test_getQuantity_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss");
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		Integer price = 2;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		Integer result = storeEntry.getQuantity();
		assertFalse(price.equals(result));
	}
}

