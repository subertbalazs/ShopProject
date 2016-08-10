import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

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

	public static boolean buyMilk() {

		Scanner reader = new Scanner(System.in);
		Integer barCode;
		do {
			// System.out.println("\nThe milkBar contains: \n" +
			// Store.milkBar.toString());
			System.out.println("\nPlease enter the barCode of the product: ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a barCode number! Please enter a valid: ");
				reader.next();
			}
			barCode = reader.nextInt();
		} while (barCode <= 0);
		for (Iterator<Entry<Integer, Milk>> i = Store.milkBar.entrySet().iterator(); i.hasNext();) {
			Entry<Integer, Milk> entry = i.next();
			Integer key = entry.getKey();
			Milk value = entry.getValue();
			if (barCode.equals(key)) {
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
