import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static String test;

	public static void main(String[] args) {


		Milk mizo = new Milk();
		mizo.setCapacity(1);
		mizo.setCompany("Mizo Csodafarm");
		mizo.setDripping(1.5);
		mizo.setPrice(280);
		mizo.setWarrant(getExpireDateFromConsole());
		System.out.println(mizo);
		checkWarranty();
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

	public static boolean checkWarranty() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date warranty = sdf.parse(Milk.getWarrant());
			Date now = sdf.parse(getDateTimeNow());

			System.out.println("The current date is: " + sdf.format(now));

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

		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
