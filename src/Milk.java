public class Milk {

	private int capacity;
	private static String warrant;
	private double dripping;
	private long price;
	private String company;

	public Milk(int capacity, String warrant, double dripping, long price, String company) {
		super();
		this.capacity = capacity;
		this.warrant = warrant;
		this.dripping = dripping;
		this.price = price;
		this.company = company;
	}

	public int getCapacity() {
		return capacity;
	}

	public static String getWarrant() {
		return warrant;
	}

	public double getDripping() {
		return dripping;
	}

	public long getPrice() {
		return price;
	}

	public String getCompany() {
		return company;
	}


	public String toString() {
		return "Capacity: " + capacity + "\n" + "Warrant: " + warrant + "\n" + "Dripping: " + dripping + "\n"
				+ "Price: " + price + " " + "\n" + "Company: " + company;
	}

}
