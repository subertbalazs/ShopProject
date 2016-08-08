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

	public static boolean isThereAnyMilk() {
		if (milkBar.isEmpty()) {
			System.out.println("\nThe milk is over.");
			return true;
		}
		System.out.println("\nThe milk is not over yet.");
		return false;
	}

	public static boolean buyMilk() {
		if (milkBar.isEmpty()) {
			System.out.println("The milkbar is empty!\n");
			return false;
		}
		System.out.println("\nThe milkBar contains: \n" + milkBar.toString());
		Scanner reader = new Scanner(System.in);
		System.out.println("\nPlease enter the barCode of the item you want to buy: ");
		Integer barCode = reader.nextInt();
		for (Iterator<Entry<Integer, Milk>> i = milkBar.entrySet().iterator(); i.hasNext();) {
			Entry<Integer, Milk> entry = i.next();

			if (barCode.equals(entry.getKey())) {
				i.remove();
				System.out.println(
						"You chose: " + barCode + "\nThe product with this barCode is removed from the milkBar!");
				printMilkBar();
				return true;
			}
		}
		System.out.println("There is no product with barCode like: " + barCode + " in the stock!");
		printMilkBar();
		return false;
	}

	public static void addMilk() {
		Milk milkObject = new Milk(GetDataFromConsole.getBarCodeFromConsole(),
				GetDataFromConsole.getCapacityFromConsole(),
				GetDataFromConsole.getExpireDateFromConsole(), GetDataFromConsole.getDrippingFromConsole(),
				GetDataFromConsole.getPriceFromConsole(), GetDataFromConsole.getCompanyFromConsole());

		milkBar.put((int) milkObject.getBarCode(), milkObject);
	}

	public static void printMilkBar() {
		System.out.println("\nThe milkBar contains: \n" + milkBar.toString() + "\n");
	}

}
