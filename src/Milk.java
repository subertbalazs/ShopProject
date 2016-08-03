public class Milk {

	private static double capacity;
	private static String warrant;
	private static double dripping;
	private static int price;
	private static String company;

	public static double getCapacity() {
		return capacity;
	}

	public static void setCapacity(double capacity) {
		Milk.capacity = capacity;
	}

	public static String getWarrant() {
		return warrant;
	}

	public static void setWarrant(String string) {
		Milk.warrant = string;
	}

	public static double getDripping() {
		return dripping;
	}

	public static void setDripping(double dripping) {
		Milk.dripping = dripping;
	}

	public static int getPrice() {
		return price;
	}

	public static void setPrice(int price) {
		Milk.price = price;
	}

	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Milk.company = company;
	}

	public String toString() {
		return "Capacity: " + capacity + "\n" + "Warrant: " + warrant + "\n" + "Dripping: " + dripping + "\n"
				+ "Price: " + price + " " + "\n" + "Company: " + company;
	}

}
