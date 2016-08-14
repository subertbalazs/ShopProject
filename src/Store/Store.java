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
	public static Hashtable<Integer, Milk> milkBar = new Hashtable<>();
	private int flag;

	public Store(String name, String address, String owner, Hashtable<Integer, Milk> milkBar) {
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
		for (Iterator<Entry<Integer, Milk>> i = bar.entrySet().iterator(); i.hasNext();) {
			Entry<Integer, Milk> entry = i.next();
			Integer key = entry.getKey();
			Milk value = entry.getValue();
			if (integerBarCode.equals(key)) {
				System.out.println(
						"You chose: " + barCode + "\nThe product with this barCode is removed from the milkBar!");
				i.remove();
				return true;
			}
		}
		System.out.println("There is no product with barCode like: " + barCode + " in the stock!");
		return false;
	}

	public static Milk createMilkInstance() {
		Milk milkObject = new Milk(GetDataFromConsole.getBarCodeFromConsole(),
				GetDataFromConsole.getCapacityFromConsole(),
				GetDataFromConsole.getExpireDateFromConsole(), GetDataFromConsole.getDrippingFromConsole(),
				GetDataFromConsole.getPriceFromConsole(), GetDataFromConsole.getCompanyFromConsole());
		return milkObject;
	}
	
	public static boolean addMilkToMilkBar(Milk milk, Hashtable bar) {
		try {
			milkBar.put((int) milk.getBarCode(), milk);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void printMilkBar() {
		System.out.println("\nThe milkBar contains: \n" + milkBar.toString() + "\n");
	}

	private class StoreEntry {
		Milk milk;
		int quantity;
		int price;

		public StoreEntry(Milk milk, int quantity, int price) {
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

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public void increaseQuantity() {

		}

		public void decreaseQuantity() {

		}

	}
}
