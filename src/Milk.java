import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Milk {

	private int capacity;
	private static String warrant;
	private double dripping;
	private long price;
	private String company;

	public Milk(int capacity, String warrant, double dripping, long price, String company) {
		super();
		this.capacity = capacity;
		Milk.warrant = warrant;
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

	public static String getExpireDateFromConsole() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the expire date (valid format: 2017-11-11): ");
		String date = reader.nextLine();
		return date;
	}


	public static String getDateTimeNow() {
		String now = LocalDateTime.now().toString();
		return now;
	}

	public static Date warantyDateParser() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date warranty = sdf.parse(Milk.getWarrant());

			return warranty;

		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Date nowDateParser() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date now = sdf.parse(getDateTimeNow());

			System.out.println("The current date is: " + sdf.format(now));
			return now;

		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static boolean checkWarranty(Date warranty, Date now) {

		if (warranty.after(now)) {
			System.out.println("The milk is not expired yet");
			return true;
		}
		if (warranty.before(now)) {
			System.out.println("The milk is expired");
			return false;
		}
		if (warranty.equals(now)) {
			System.out.println("The expire date is today");
			return true;
		}
		return false;
	}

	public String toString() {
		return "Capacity: " + capacity + "\n" + "Warrant: " + warrant + "\n" + "Dripping: " + dripping + "\n"
				+ "Price: " + price + " " + "\n" + "Company: " + company;
	}

	public static int getCapacityFromConsole() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the capacity in ml (valid format: 500,1000 or 1500 etc.): ");
		int capacity = reader.nextInt();
		return capacity;
	}

	public static double getDrippingFromConsole() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the dripping (valid format: 1,5 or 2,8 or 3,5 etc.): ");
		double dripping = reader.nextDouble();
		return dripping;
	}

	public static long getPriceFromConsole() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the price in Ft (valid format: 280 etc.): ");
		long price = reader.nextInt();
		return price;
	}

	public static String getCompanyFromConsole() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the company name");
		String company = reader.nextLine();
		return company;
	}


}
