package Main;

import java.util.Scanner;

import store.Store;

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

	static int addFoodSubMenuItemScanner() {

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

	static int milkLifeSubMenuItemScanner() {

		Scanner reader = new Scanner(System.in);
		int minimumMenuItem = 0;
		int maximumMenuItem = 2;
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
		System.out.println("1 - Add food to the stock");
		System.out.println("2 - Is there any product in the stock?");
		System.out.println("3 - Buy food");
		System.out.println("4 - Check warranty");
	}

	static void drawAddMilkSubMenu() {
		System.out.println("---=== ADD FOOD SUBMENU ===---");
		System.out.println("1 - Add MILK to the stock with NEW barcode");
		System.out.println("2 - Add MILK to the stock with EXISTING barcode");
		System.out.println("3 - Add CHEESE to the stock with NEW barcode");
		System.out.println("4 - Add CHEESE to the stock with EXISTING barcode");

	}

	static void drawMilkLifeSubMenu() {
		System.out.println("---=== MILK LIFE SUBMENU ===---");
		System.out.println("1 - Add LONG-LIFE milk to the stock");
		System.out.println("2 - Add SEMI-LONG-LIFE milk to the stock");

	}

	static void menuLogic(int chosen) {
		final int addMilk = 1;
		final int isThereMilk = 2;
		final int buyMilk = 3;
		final int checkWarranty = 4;

		if (chosen == addMilk) {
			drawAddMilkSubMenu();
			addFoodSubMenuLogic(addFoodSubMenuItemScanner());

		} else if (chosen == isThereMilk) {
			Store.isThereAnyMilk(Store.grocery);
			createMenuStuff();
		} else if (chosen == buyMilk) {
			if (!Store.isThereAnyMilk(Store.grocery)) {
				Store.buyMilk(GetDataFromConsole.getBarCodeFromConsole(), Store.grocery);
			}
			createMenuStuff();
		} else if (chosen == checkWarranty) {
			if (!Store.isThereAnyMilk(Store.grocery)) {
				GetDataFromConsole.checkWarranty(GetDataFromConsole.warantyDateParser(),
						GetDataFromConsole.nowDateParser());
				createMenuStuff();
			}
			createMenuStuff();
		}
	}

	static void addFoodSubMenuLogic(int chosen) {
		final int newMilk = 1;
		final int existingMilk = 2;
		final int newCheese = 3;
		final int existingCheese = 4;

		if (chosen == newMilk) {
			drawMilkLifeSubMenu();
			milkLifeMenuLogic(addFoodSubMenuItemScanner());
		} else if (chosen == existingMilk) {
			if (!Store.isThereAnyMilk(Store.grocery)) {
				Store.addExistingProduct(GetDataFromConsole.getBarCodeFromConsole(), Store.grocery);
			}
			createMenuStuff();
		} else if (chosen == newCheese) {
			Store.addNewProductToStore(Store.createStoreEntryInstanceCheese(Store.createStoreInstance()),
					Store.grocery);
			Store.printStore();
			createMenuStuff();
		} else if (chosen == existingCheese) {
			if (!Store.isThereAnyMilk(Store.grocery)) {
				Store.addExistingProduct(GetDataFromConsole.getBarCodeFromConsole(), Store.grocery);
			}
		}
		createMenuStuff();
	}

	static void milkLifeMenuLogic(int chosen) {
		final int longLife = 1;
		final int semiLongLife = 2;

		if (chosen == longLife) {
			Store.addNewProductToStore(Store.createStoreEntryInstanceLongLife(Store.createStoreInstance()),
					Store.grocery);
			Store.printStore();
			createMenuStuff();
		} else if (chosen == semiLongLife) {
			Store.addNewProductToStore(Store.createStoreEntryInstanceSemiLongLife(Store.createStoreInstance()),
					Store.grocery);
			Store.printStore();
			createMenuStuff();
		}
		createMenuStuff();
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
