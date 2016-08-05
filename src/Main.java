import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static String test;

	public static void main(String[] args) {
		Milk mizo = new Milk(1, getExpireDateFromConsole(), 1.5, 280, "Mizo Csodafarm");
		System.out.println(mizo);
		checkWarranty(warantyDateParser(), nowDateParser());
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
}
