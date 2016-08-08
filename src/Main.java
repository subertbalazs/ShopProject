import java.util.Scanner;

public class Main {

	public static String test;

	public static void main(String[] args) {

		/*
		 * Milk mizo = new Milk(1, Milk.getExpireDateFromConsole(), 1.5, 280,
		 * "Mizo Csodafarm"); System.out.println(mizo);
		 * Milk.checkWarranty(Milk.warantyDateParser(), Milk.nowDateParser());
		 * 
		 * Milk magyarTej = new Milk(1, Milk.getExpireDateFromConsole(), 2.8,
		 * 250, "Magyar Tej Zrt."); System.out.println(mizo);
		 * Milk.checkWarranty(Milk.warantyDateParser(), Milk.nowDateParser());
		 * 
		 * Milk riska = new Milk(1, Milk.getExpireDateFromConsole(), 1.5, 200,
		 * "Riska Tej Zrt."); System.out.println(mizo);
		 * Milk.checkWarranty(Milk.warantyDateParser(), Milk.nowDateParser());
		 * 
		 * Milk abaujTej = new Milk(1, Milk.getExpireDateFromConsole(), 2.8,
		 * 260, "Abaúj Tej Zrt."); System.out.println(mizo);
		 * Milk.checkWarranty(Milk.warantyDateParser(), Milk.nowDateParser());
		 * 
		 * Store.milkBar = new ArrayList<>(); Store.milkBar.add(mizo);
		 * 
		 * Store.milkBar.add(magyarTej); Store.milkBar.add(abaujTej);
		 * Store.milkBar.add(riska);
		 */
		
		/*
		 * Store.addMilk();
		 * GetDataFromConsole.checkWarranty(GetDataFromConsole.warantyDateParser
		 * (), GetDataFromConsole.nowDateParser()); Store.isThereAnyMilk();
		 * Store.buyMilk();
		 */

		drawMenu();
		Menu(menuItemScanner());
	}

	private static int menuItemScanner() {

		Scanner reader = new Scanner(System.in);
		int menItem;
		do {
			System.out.println("Please enter the number of the menu item you would like to choose: ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number!");
				reader.next();
			}
			menItem = reader.nextInt();
		} while (menItem <= 0 || menItem > 3);
		// clearScreen();
		return menItem;
	}

	private static void drawMenu() {
		System.out.println("---=== MENU ===---");
		System.out.println("1 - Add milk to the stock");
		System.out.println("2 - Is there any milk in the stock?");
		System.out.println("3 - I would like to buy milk");
		System.out.println("4 - Exit");
	}

	private static void Menu(int choosen) {
		if (choosen == 1) {
			Store.addMilk();
			Store.printMilkBar();
			drawMenu();
			Menu(menuItemScanner());
		} else if (choosen == 2) {
			Store.isThereAnyMilk();
			Store.printMilkBar();
			drawMenu();
			Menu(menuItemScanner());
		} else if (choosen == 3) {
			Store.buyMilk();
			drawMenu();
			Menu(menuItemScanner());
		}
	}

	private static void clearScreen() {
		// it is not working, must be solved
		System.out.print("\033[H\033[2J");
	}
}
