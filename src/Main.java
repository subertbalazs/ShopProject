import java.util.Scanner;

public class Main {

	public static String test;

	public static void main(String[] args) {
		drawMenu();
		Menu(menuItemScanner());
	}

	static int menuItemScanner() {

		Scanner reader = new Scanner(System.in);
		int menItem;
		do {
			System.out.println("Please enter the number of the menu item you would like to choose: ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number!");
				reader.next();
			}
			menItem = reader.nextInt();
		} while (menItem <= 0 || menItem > 4);
		// clearScreen();
		return menItem;
	}

	static void drawMenu() {
		System.out.println("---=== MENU ===---");
		System.out.println("1 - Add milk to the stock");
		System.out.println("2 - Is there any milk in the stock?");
		System.out.println("3 - I would like to buy milk");
		System.out.println("4 - Warranty check");
	}

	static void Menu(int choosen) {
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
		} else if (choosen == 4) {
			if (!Store.isThereAnyMilk()) {
					GetDataFromConsole.checkWarranty(GetDataFromConsole.warantyDateParser(),
							GetDataFromConsole.nowDateParser());
				drawMenu();
				Menu(menuItemScanner());
			}
			drawMenu();
			Menu(menuItemScanner());
		}
	}

	private static void clearScreen() {
		// it is not working, must be solved
		System.out.print("\033[H\033[2J");
	}
}
