package store;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import Main.GetDataFromConsole;
import Main.Menu;
import products.Food;

public class Store {

	private String name;
	private String address;
	private String owner;
	public Hashtable<Integer, StoreEntry> grocery = new Hashtable<>();

	public static Store exactStore;
	private boolean isClosed = true;
	public static ArrayList<Store> storeList = new ArrayList();

	public Store(String name, String address, String owner, Hashtable<Integer, StoreEntry> grocery, boolean isClosed) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.grocery = grocery;
	}

	public Store(String name, String address, String owner, boolean isClosed) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getOwner() {
		return owner;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public static Store createStoreInstance() {
		Store storeInstance = new Store(GetDataFromConsole.getStoreName(), GetDataFromConsole.getStoreAddress(),
				GetDataFromConsole.getOwner(), true);
		return storeInstance;
	}
	
	public static Store getStoreByName(ArrayList<Store> storeList) {
		String storeToFind = GetDataFromConsole.getStoreName();
		for (int i = 0; i < storeList.size(); i++) {
			if (storeToFind.equals(storeList.get(i).getName())) {
				storeList.get(i).printStore();
				return exactStore = storeList.get(i);
			}
		}
		System.out.println("This is not valid store");
		Menu.createMenuStuff();
		return null;
	}

	public static Store returnValueTesterForGetStoreByName(Store store) {
		while (store == null) {
			Menu.drawAddFoodSubMenu();
			Menu.addFoodSubMenuLogic(Menu.addFoodSubMenuItemScanner());
		}
		return store;
	}

	public static boolean addStoreToList(Store store, ArrayList<Store> storeList) {
		try {
			storeList.add(store);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public static void getStoreList() {
		if (storeList.size() <= 0) {
			System.out.println("There is not any store recorded!");
		} else {
			System.out.println("\nStores: ");
			for (int i = 0; i < storeList.size(); i++) {
				System.out.println(storeList.get(i).getName());
			}
		}
	}

	public static boolean isTheStoreListEmpty(ArrayList<Store> storeList) {
		if (storeList.isEmpty()) {
			System.out.println("\nThere is not any store...");
			return true;
		}
		return false;
	}

	public static boolean deleteStore() {
		String nameToDelete = GetDataFromConsole.getStoreName();
		for (int i = 0; i < storeList.size(); i++) {
			if (nameToDelete.equals(storeList.get(i).getName())) {
				storeList.remove(i);
				System.out.println("The store: " + i + "is deleted");
				return true;
			}
		}
		System.out.println("This is not valid store");
		return false;
	}

	public boolean openCloseExactShop() {
		if (isClosed) {
			isClosed = false;
			System.out.println("The store is now open");
		} else {
			isClosed = true;
			System.out.println("The store is now closed");
		}
		return isClosed;
	}

	public static boolean isTheGroceryEmpty(Hashtable bar) {
		if (bar.isEmpty()) {
			System.out.println("\nThe stock is empty.");
			return true;
		}
		System.out.println("\nThe stock contains: \n" + bar.toString());
		return false;
	}

	public static boolean buyProduct(long barCode, Hashtable bar) {
		Integer integerBarCode = (int) (long) barCode;
		for (Iterator<Entry<Integer, StoreEntry>> i = bar.entrySet().iterator(); i.hasNext();) {
			Entry<Integer, StoreEntry> entry = i.next();
			Integer key = entry.getKey();
			StoreEntry value = entry.getValue();
			if (integerBarCode.equals(key)) {
				if (value.getQuantity() > 1) {
					int decreaser = GetDataFromConsole.getQuantityFromConsole();
					if (decreaser == value.getQuantity()) {
						System.out.println("You chose: " + barCode
								+ "\nThe product with this barCode is removed from the milkBar!");
						i.remove();
						return true;
					} else if (decreaser > value.getQuantity()) {
						System.out.println("There is less than " + decreaser + " box of the product with barCode: "
								+ barCode + ". (Quantity: " + value.getQuantity() + ")");
						return false;
					} else {
						value.decreaseQuantity(decreaser);
						System.out
								.println("You bought " + decreaser + " of the product with barCode: " + barCode + ".");
						return true;
					}
				} else {
					System.out.println(
							"You chose: " + barCode + "\nThe product with this barCode is removed from the milkBar!");
					i.remove();
					return true;
				}
			}
		}
		System.out.println("There is no product with barCode like: " + barCode + " in the stock!");
		return false;
	}

	public static StoreEntry createStoreEntryInstanceLongLife() {
		StoreEntry storeEntryObject = exactStore.new StoreEntry(ProductFactory.createLongLifeMilkInstance(),
				GetDataFromConsole.getQuantityFromConsole(), GetDataFromConsole.getPriceFromConsole());

		return storeEntryObject;
	}

	public static StoreEntry createStoreEntryInstanceSemiLongLife() {
		StoreEntry storeEntryObject = exactStore.new StoreEntry(ProductFactory.createSemiLongLifeMilkInstance(),
				GetDataFromConsole.getQuantityFromConsole(), GetDataFromConsole.getPriceFromConsole());

		return storeEntryObject;
	}

	public static StoreEntry createStoreEntryInstanceCheese() {
		StoreEntry storeEntryObject = exactStore.new StoreEntry(ProductFactory.createCheeseInstance(),
				GetDataFromConsole.getQuantityFromConsole(), GetDataFromConsole.getPriceFromConsole());

		return storeEntryObject;
	}

	public boolean addNewProductToStore(StoreEntry storeEntry) {
		try {
			exactStore.grocery.put((int) storeEntry.food.getBarCode(), storeEntry);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addExistingProduct(long barCode) {
		Integer integerBarCode = (int) (long) barCode;
		for (Iterator<Entry<Integer, StoreEntry>> i = exactStore.grocery.entrySet().iterator(); i.hasNext();) {
			Entry<Integer, StoreEntry> entry = i.next();
			Integer key = entry.getKey();
			StoreEntry value = entry.getValue();
			if (integerBarCode.equals(key)) {
				int increaser = GetDataFromConsole.getQuantityFromConsole();
				value.increaseQuantity(increaser);
				System.out.println("The quantity of the product with " + barCode + " is increased with " + increaser
						+ " (Total: " + value.getQuantity() + ")");
				return true;
			}
		}
		System.out.println("There is no product with barCode like: " + barCode + " in the stock!");
		return false;
	}

	public void printStore() {
		System.out.println("\nThe store contains: \n" + this.grocery.toString() + "\n");
	}

	public static Date warantyDateParser() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date warranty = sdf.parse(Food.returnValueTesterForGetWarrantyByConsole(Food
.getWarrantyByBarCode(GetDataFromConsole.getBarCodeFromConsole(), exactStore.grocery)));
			return warranty;

		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public class StoreEntry {
		Food food;
		int quantity;
		long price;

		public StoreEntry(Food food, int quantity, long price) {
			super();
			this.food = food;
			this.quantity = quantity;
			this.price = price;
		}

		public Food getMilk() {
			return food;
		}

		public void setMilk(Food milk) {
			this.food = milk;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public void increaseQuantity(int incQuantity) {
			this.quantity += incQuantity;
		}

		public void decreaseQuantity(int decQuantity) {
			this.quantity -= decQuantity;
		}

		public String toString() {
			return "Food: " + food + "\n" + "Price: " + price + "\n" + "Quantity: " + quantity + "\n" + food.getClass();
		}

	}

}
