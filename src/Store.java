import java.util.ArrayList;
import java.util.Scanner;

public class Store {

	private String name;
	private String address;
	private String owner;
	public static ArrayList<Milk> milkBar = new ArrayList<>();
	private int flag;

	public Store(String name, String address, String owner, ArrayList<Milk> milkBar) {
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
		System.out.println("\nThe milkBar contains: \n" + milkBar.toString());
		Scanner reader = new Scanner(System.in);
		System.out.println("\nPlease enter the index of the item you want to buy: ");
		int index = reader.nextInt();
		if (index > milkBar.lastIndexOf(milkBar)) {
			System.out.println("There is no index like: " + index + "in this array");
			return false;
		}
		milkBar.remove(index);
		System.out.println("You chose: " + index + "\nThe product with this index is removed from the milkBar!");
		System.out.println("\nThe milkBar contains: \n" + milkBar.toString());
		return true;
	}

	public static void addMilk() {
		Milk milkObject = new Milk(GetDataFromConsole.getCapacityFromConsole(),
				GetDataFromConsole.getExpireDateFromConsole(), GetDataFromConsole.getDrippingFromConsole(),
				GetDataFromConsole.getPriceFromConsole(), GetDataFromConsole.getCompanyFromConsole());

		// milkBar = new ArrayList<>();
		milkBar.add(milkObject);
	}

	public static void printMilkBar() {
		System.out.println(milkBar);
	}

}
