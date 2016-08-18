package Store;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import Main.GetDataFromConsole;
import Milk.Milk;

public class Store {

	private String name;
	private String address;
	private String owner;
	public static Hashtable<Integer, StoreEntry> milkBar = new Hashtable<>();
	private int flag;

	public Store(String name, String address, String owner, Hashtable<Integer, StoreEntry> milkBar) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.milkBar = milkBar;
	}

	public Store(String name, String address, String owner) {
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

	public static boolean isThereAnyMilk(Hashtable bar) {
		if (bar.isEmpty()) {
			System.out.println("\nThe milk is over.");
			return true;
		}
		System.out.println("\nThe milk is not over yet.");
		System.out.println("\nThe milkBar contains: \n" + bar.toString());
		return false;
	}

	public static boolean buyMilk(long barCode, Hashtable bar) {
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
					}
 else if (decreaser > value.getQuantity()) {
						System.out.println("There is less than " + decreaser + " box of the product with barCode: "
								+ barCode + ". (Quantity: "
								+ value.getQuantity() + ")");
						return false;
					}
 else {
					value.decreaseQuantity(decreaser);
						System.out
								.println("You bought " + decreaser + " of the product with barCode: " + barCode + ".");
					return true;
					}
				}
				else {
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

	public static Milk createMilkInstance() {
		Milk milkObject = new Milk(GetDataFromConsole.getBarCodeFromConsole(),
				GetDataFromConsole.getCapacityFromConsole(),
				GetDataFromConsole.getExpireDateFromConsole(), GetDataFromConsole.getDrippingFromConsole(),
 GetDataFromConsole.getCompanyFromConsole());
		return milkObject;
	}
	
	public static Store createStoreInstance() {
		Store storeInstance = new Store("TestBolt", "Miskolc", "The Boss");
		return storeInstance;
	}

	public static StoreEntry createStoreEntryInstance(Store store) {
		StoreEntry storeEntryObject = store.new StoreEntry(createMilkInstance(),
				GetDataFromConsole.getQuantityFromConsole(), GetDataFromConsole.getPriceFromConsole());

		return storeEntryObject;
	}

	public static boolean addNewMilkToMilkBar(StoreEntry storeEntry, Hashtable bar) {
		try {
			bar.put((int) storeEntry.milk.getBarCode(), storeEntry);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean addExistingMilk(long barCode, Hashtable bar) {
		Integer integerBarCode = (int) (long) barCode;
		for (Iterator<Entry<Integer, StoreEntry>> i = bar.entrySet().iterator(); i.hasNext();) {
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

 	public static void printMilkBar() {
		System.out.println("\nThe milkBar contains: \n" + milkBar.toString() + "\n");
	}

	public class StoreEntry {
		Milk milk;
		int quantity;
		long price;

		public StoreEntry(Milk milk, int quantity, long price) {
			super();
			this.milk = milk;
			this.quantity = quantity;
			this.price = price;
		}

		public Milk getMilk() {
			return milk;
		}

		public void setMilk(Milk milk) {
			this.milk = milk;
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
			return "Milk: " + milk + "\n" + "Price: " + price + "\n" + "Quantity: " + quantity + "\n";
		}

	}
}
