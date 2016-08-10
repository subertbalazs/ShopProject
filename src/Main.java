import java.util.Scanner;

public class Main {

	public static String test;

	public static void main(String[] args) {
		createMenuStuff();
	}

	static int menuItemScanner() {

		Scanner reader = new Scanner(System.in);
		int minimumMenuItem = 0;
		int maximumMenuItem = 4;
		int menuItem;
		do {
			System.out.println("Please enter the number of the menu item you would like to choose: ");
			while (!reader.hasNextInt()) {
				System.out.println("This is not a number! Please enter the number of a the menu item: ");
				reader.next();
			}
			menuItem = reader.nextInt();
		} while (menuItem <= minimumMenuItem || menuItem > maximumMenuItem);
		// clearScreen();
		return menuItem;
	}

	static void drawMenu() {
		System.out.println("---=== MENU ===---");
		System.out.println("1 - Add milk to the stock");
		System.out.println("2 - Is there any milk in the stock?");
		System.out.println("3 - Buy milk");
		System.out.println("4 - Check warranty");
	}

	static void Menu(int choosen) {
		if (choosen == 1) {
			Store.addMilkToMilkBar(Store.createMilkInstance(), Store.milkBar);
			Store.printMilkBar();
			createMenuStuff();
		} else if (choosen == 2) {
			Store.isThereAnyMilk(Store.milkBar);
			Store.printMilkBar();
			createMenuStuff();
		} else if (choosen == 3) {
			if (!Store.isThereAnyMilk(Store.milkBar)) {
				Store.buyMilk();
			}
			createMenuStuff();
		} else if (choosen == 4) {
			if (!Store.isThereAnyMilk(Store.milkBar)) {
					GetDataFromConsole.checkWarranty(GetDataFromConsole.warantyDateParser(),
							GetDataFromConsole.nowDateParser());
				createMenuStuff();
			}
			createMenuStuff();
		}
	}

	public static void createMenuStuff() {
		drawMenu();
		Menu(menuItemScanner());
	}

	private static void clearScreen() {
		// it is not working, must be solved
		System.out.print("\033[H\033[2J");
	}

}
