package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Hashtable;

import org.junit.Test;

import products.LongLifeMilk;
import products.Milk;
import store.Store;
import store.Store.StoreEntry;

public class TestFood {

	@Test
	public void test_getWarrant_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		String warranty = "1999-11-11";
		String result = milk.getWarrant();
		assertEquals(result, warranty);
	}
	@Test
	public void test_getWarrant_ReturnTrue_inCaseOfIncorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		String warranty = "2111-11-11";
		String result = milk.getWarrant();
		assertFalse(warranty.equals(result));
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
		Hashtable<Integer, StoreEntry> testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss", false);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		testHashTable.put(1111, storeEntry);
		int barCode = 1111;
		String result = Milk.getWarrantyByBarCode(barCode, testHashTable);
		assertEquals(result, milk.getWarrant());
	}
	@Test
	public void test_getWarrantyByBarCode_ReturnNull_inCaseOfIncorrectBarCode() {
		Hashtable<Integer, StoreEntry> testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss", false);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		StoreEntry storeEntry = store.new StoreEntry(milk, 1, 230);
		testHashTable.put(1111, storeEntry);
		int barCode = 2222;
		String result = Milk.getWarrantyByBarCode(barCode, testHashTable);
		assertEquals(result, null);
	}
	@Test
	public void test_getWarrantyByBarCode_ReturnBarCode_inCaseOfMulitpleItemAndCorrectBarCode() {
		Hashtable<Integer, StoreEntry> testHashTable = new Hashtable<>();
		Store store = new Store("TestBolt", "Miskolc", "The Boss", false);
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		Milk milk2 = new LongLifeMilk(2222, 500, "2017-11-11", 2, "test2");
		StoreEntry storeEntry1 = store.new StoreEntry(milk, 1, 230);
		StoreEntry storeEntry2 = store.new StoreEntry(milk2, 2, 240);
		testHashTable.put(1111, storeEntry1);
		testHashTable.put(2222, storeEntry2);
		long barCode = 2222;
		String result = Milk.getWarrantyByBarCode(barCode, testHashTable);
		assertEquals(result, milk2.getWarrant());
	}
	@Test
	public void test_returnValueTesterForGetWarrantyByConsole_ReturnDate_inCaseOfDate() {
		String date = "2017-11-11";
		String result = Milk.returnValueTesterForGetWarrantyByConsole(date);
		assertEquals("2017-11-11", result);
	}

}
