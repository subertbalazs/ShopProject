package Main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class GetDataFromConsole {

	public static String getExpireDateFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		String date;
		String pattern = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		do {
			System.out.println("Please enter the expire date (valid format: 2017-11-11): ");
			date = reader.nextLine();
		} while (!date.matches(pattern));
		return date;
	}

	public static String getDateTimeNow() {
		String now = LocalDateTime.now().toString();
		return now;
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
			System.out.println("The product is not expired yet.\n");
			return true;
		}
		if (warranty.before(now)) {
			System.out.println("The product is expired.\n");
			return false;
		}
		if (warranty.equals(now)) {
			System.out.println("The expire date is today.\n");
			return true;
		}
		return false;
	}

	public static int getCapacityFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int capacity;
		do {
			System.out.println("Please enter the capacity in ml (valid format: 500,1000 or 1500 etc., max 10 chars): ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number! Enter valid number: ");
				reader.next();
			}
			capacity = reader.nextInt();
		} while (capacity <= 0);
		return capacity;
	}

	public static double getWeightFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		double weight;
		do {
			System.out.println("Please enter the weight (valid format: 1,5 or 2,8 or 3,5 etc., max 10 chars): ");
			while (!reader.hasNextDouble()) {
				System.out.println("Please enter a number(This is not valid format: 1.5, max 10 chars): ");
				reader.next();
			}
			weight = reader.nextDouble();
		} while (weight <= 0);
		return weight;
	}

	public static double getDrippingFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		double dripping;
		do {
			System.out.println("Please enter the dripping (valid format: 1,5 or 2,8 or 3,5 etc.): ");
			while (!reader.hasNextDouble()) {
				System.out.println("Please enter a number(This is not valid format: 1.5): ");
				reader.next();
			}
			dripping = reader.nextDouble();
		} while (dripping <= 0);
		return dripping;
	}

	public static long getPriceFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		long price;
		do {
			System.out.println("Please enter the price in Ft (valid format: 280 etc., max 10 chars): ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number! Enter valid number: ");
				reader.next();
			}
			price = reader.nextInt();
		} while (price <= 0);
		return price;
	}

	public static String getCompanyFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the company name: ");
		String company = reader.nextLine();
		return company;
	}

	public static long getBarCodeFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		long barCode;
		do {
			System.out.println("Please enter the barCode of the product (max 10 chars, numbers only): ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a barCode number! Please enter a valid: ");
				reader.next();
			}
			barCode = reader.nextInt();
		} while (barCode <= 0);
		return barCode;
	}

	public static int getQuantityFromConsole() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int quantity;
		do {
			System.out.println("Please enter the quantity (valid number, max 10 chars): ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number! Enter valid number: ");
				reader.next();
			}
			quantity = reader.nextInt();
		} while (quantity <= 0);
		return quantity;
	}

	public static String getStoreName() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the name of the store: ");
		String storeName = reader.nextLine();
		return storeName;
	}

	public static String getStoreAddress() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the addresse of the store: ");
		String storeAddresse = reader.nextLine();
		return storeAddresse;
	}

	public static String getOwner() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the store owner's name: ");
		String owner = reader.nextLine();
		return owner;
	}
	
}