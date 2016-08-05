import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class GetDataFromConsole {

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

			System.out.println("\nThe current date is: " + sdf.format(now));
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

	public static int getCapacityFromConsole() {
		Scanner reader = new Scanner(System.in);
		int capacity;
		do {
			System.out.println("Please enter the capacity in ml (valid format: 500,1000 or 1500 etc.): ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number!");
				reader.next();
			}
			capacity = reader.nextInt();
		} while (capacity <= 0);
		return capacity;
	}

	public static double getDrippingFromConsole() {
		Scanner reader = new Scanner(System.in);
		double dripping;
		do {
			System.out.println("Please enter the dripping (valid format: 1,5 or 2,8 or 3,5 etc.): ");
			while (!reader.hasNextDouble()) {
				System.out.println("Please enter a positive double number!");
				reader.next();
			}
			dripping = reader.nextDouble();
		} while (dripping <= 0);
		return dripping;
	}

	public static long getPriceFromConsole() {
		Scanner reader = new Scanner(System.in);
		long price;
		do {
			System.out.println("Please enter the price in Ft (valid format: 280 etc.): ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number!");
				reader.next();
			}
			price = reader.nextInt();
		} while (price <= 0);
		return price;
	}

	public static String getCompanyFromConsole() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the company name: ");
		String company = reader.nextLine();
		return company;
	}
}
