package Main;

import java.util.Scanner;

import Store.Store;

public class Menu {

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

	static void menuLogic(int choosen) {
		final int addMilk = 1;
		final int isThereMilk = 2;
		final int buyMilk = 3;
		final int checkWarranty = 4;

		if (choosen == addMilk) {
			Store.addMilkToMilkBar(Store.createStoreEntryInstance(Store.createStoreInstance()), Store.milkBar);
			// Store.createMilkInstance(), Store.milkBar)
			Store.printMilkBar();
			createMenuStuff();
		} else if (choosen == isThereMilk) {
			Store.isThereAnyMilk(Store.milkBar);
			Store.printMilkBar();
			createMenuStuff();
		} else if (choosen == buyMilk) {
			if (!Store.isThereAnyMilk(Store.milkBar)) {
				Store.buyMilk(GetDataFromConsole.getBarCodeFromConsole(), Store.milkBar);
			}
			createMenuStuff();
		} else if (choosen == checkWarranty) {
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
		menuLogic(menuItemScanner());
	}

	private static void clearScreen() {
		// it is not working, must be solved
		System.out.print("\033[H\033[2J");
	}
}
