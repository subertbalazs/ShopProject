package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;

import products.Food;
import products.LongLifeMilk;
import products.Milk;
import store.Store;
import store.Store.StoreEntry;

public class TestStore {

	@Test
	public void test_getName_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		String name = "TestBolt";
		String result = store.getName();
		assertEquals(result, name);
	}
	@Test
	public void test_getName_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		String name = "Boltocska";
		String result = store.getName();
		assertFalse(name.equals(result));
	}
	@Test
	public void test_getAddress_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		String address = "Miskolc";
		String result = store.getAddress();
		assertEquals(result, address);
	}
	@Test
	public void test_getOwner_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		String owner = "Nem Boss";
		String result = store.getOwner();
		assertFalse(owner.equals(result));
	}
	@Test
	public void test_getOwner_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		String owner = "The Boss";
		String result = store.getOwner();
		assertEquals(result, owner);
	}
	@Test
	public void test_isClosed_ReturnTrue_inCaseOfClosedStoreInstance() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		boolean isClosed = true;
		boolean result = store.isClosed();
		assertEquals(result, isClosed);
	}
	@Test
	public void test_isTheGroceryEmpty_returnTrue_inCaseOfEmptyHashTable() {
		Hashtable testHashTable = new Hashtable<>();
		boolean result = Store.isTheGroceryEmpty(testHashTable);
		assertEquals(result, true);
	}
	@Test
	public void test_addStoreToList_returnTrue_inCaseValidStore() {
		ArrayList<Store> storeList = new ArrayList();
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		boolean result = Store.addStoreToList(store, storeList);
		boolean expected = true;
		assertEquals(result, expected);
	}
	@Test
	public void test_isTheStoreListEmpty_returnTrue_inCaseOfEmptyStoreList() {
		ArrayList<Store> storeList = new ArrayList();
		boolean result = Store.isTheStoreListEmpty(storeList);
		assertEquals(result, true);
	}
	@Test
	public void test_isTheStoreListEmpty_returnFalse_inCaseOfOneItem() {
		ArrayList<Store> storeList = new ArrayList();
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		storeList.add(store);
		boolean expected = false;
		boolean result = Store.isTheStoreListEmpty(storeList);
		assertEquals(result, expected);
	}
	@Test
	public void test_openCloseExactShop_returnFalse_inCaseOfClosedShop() {
		ArrayList<Store> storeList = new ArrayList();
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		storeList.add(store);
		boolean expected = false;
		boolean result = store.openCloseExactShop();
		assertEquals(result, expected);
	}
	@Test
	public void test_isTheGroceryEmpty_returnFalse_inCaseOfHashTableWithOneItem() {
		Hashtable testHashTable = new Hashtable<>();
		testHashTable.put(1, "one");
		boolean result = Store.isTheGroceryEmpty(testHashTable);
		assertEquals(result, false);
	}
	@Test
	public void test_buyProduct_returnFalse_inCaseOfEmptyHashTable() {
		Hashtable testHashTable = new Hashtable<>();
		int barCode = 1;
		boolean result = Store.buyProduct(barCode, testHashTable);
		assertEquals(result, false);
	}
	@Test
	public void test_buyProduct_returnFalse_inCaseOfOneItemWithWrongKey() {
		Hashtable<Integer, StoreEntry> testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		StoreEntry storeEntry1 = store.new StoreEntry(milk, 2, 230);
		testHashTable.put(1, storeEntry1);
		int barCode = 2;
		boolean result = Store.buyProduct(barCode, testHashTable);
		assertEquals(result, false);
	}
	@Test
	public void test_getMilk_ReturnTrue_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		Food result = storeEntry.getMilk();
		assertEquals(result, milk);
	}
	@Test
	public void test_getPrice_ReturnTure_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		long price = 230;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		long result = storeEntry.getPrice();
		assertEquals(result, price);
	}
	@Test
	public void test_getMilk_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		long price = 280;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		long result = storeEntry.getPrice();
		assertFalse(price == result);
	}
	@Test
	public void test_getQuantity_ReturnTure_inCaseOfCorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		int price = 1;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		int result = storeEntry.getQuantity();
		assertEquals(result, price);
	}
	@Test
	public void test_getQuantity_ReturnFalse_inCaseOfIncorrectValue() {
		Store store = new Store("TestBolt", "Miskolc", "The Boss", true);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-12-12", 1, "testComp");
		Integer price = 2;
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		Integer result = storeEntry.getQuantity();
		assertFalse(price.equals(result));
	}
}

