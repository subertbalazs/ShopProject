package Main;

import java.util.Scanner;

import store.Store;

public class Menu {

	static void drawMainMenu() {
		System.out.println("---=== MENU ===---");
		System.out.println("1 - Add new Store");
		System.out.println("2 - Inventory changes");
		System.out.println("3 - Delete store");
	}
	
	static int mainMenuItemScanner() {
		Scanner reader = new Scanner(System.in);
		int minimumMenuItem = 0;
		int maximumMenuItem = 3;
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
	
	static void mainMenuLogic(int chosen) {
		final int addStore = 1;
		final int fillStore = 2;
		final int delete = 3;

		if (chosen == addStore) {
			Store.addStoreToList(Store.createStoreInstance());
			Store.getStoreList();
			createMenuStuff();

		} else if (chosen == fillStore) {
			if (!Store.isThereAnyStore()) {
				Store.getStoreList();
				Store.getStoreByName();
				drawStoreMenu();
				storeMenuLogic(storeMenuItemScanner());
			}
			createMenuStuff();

		} else if (chosen == delete) {
			Store.getStoreList();
			Store.deleteStore();
			createMenuStuff();

		}
		createMenuStuff();

	}

	static void drawStoreMenu() {
		System.out.println("---=== Inventrory changes ===---");
		System.out.println("1 - Add food to the stock");
		System.out.println("2 - Is there any product in the stock?");
		System.out.println("3 - Buy something");
		System.out.println("4 - Check warranty");
	}
	
	static int storeMenuItemScanner() {

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
	
	static void storeMenuLogic(int chosen) {
		final int addFood = 1;
		final int isThereMilk = 2;
		final int buyMilk = 3;
		final int checkWarranty = 4;
		
		if (chosen == addFood) {
			drawAddFoodSubMenu();
			addFoodSubMenuLogic(addFoodSubMenuItemScanner());
			
		} else if (chosen == isThereMilk) {
			Store.isThereAnyMilk(Store.exactStore.grocery);
			createMenuStuff();
		} else if (chosen == buyMilk) {
			if (!Store.isThereAnyMilk(Store.exactStore.grocery)) {
				Store.buyProduct(GetDataFromConsole.getBarCodeFromConsole(), Store.exactStore.grocery);
			}
			createMenuStuff();
		} else if (chosen == checkWarranty) {
			if (!Store.isThereAnyMilk(Store.exactStore.grocery)) {
				GetDataFromConsole.checkWarranty(Store.warantyDateParser(),
						GetDataFromConsole.nowDateParser());
				createMenuStuff();
			}
			createMenuStuff();
		}
	}
	
	public static void drawAddFoodSubMenu() {
		System.out.println("---=== ADD FOOD SUBMENU ===---");
		System.out.println("1 - Add MILK to the stock with NEW barcode");
		System.out.println("2 - Add MILK to the stock with EXISTING barcode");
		System.out.println("3 - Add CHEESE to the stock with NEW barcode");
		System.out.println("4 - Add CHEESE to the stock with EXISTING barcode");
		
	}

	public static int addFoodSubMenuItemScanner() {

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

	public static void addFoodSubMenuLogic(int chosen) {
		final int newMilk = 1;
		final int existingMilk = 2;
		final int newCheese = 3;
		final int existingCheese = 4;
		
		if (chosen == newMilk) {
			drawMilkLifeSubMenu();
			milkLifeMenuLogic(addFoodSubMenuItemScanner());
		} else if (chosen == existingMilk) {
			if (!Store.isThereAnyMilk(Store.exactStore.grocery)) {
				Store.exactStore.addExistingProduct(GetDataFromConsole.getBarCodeFromConsole());
			}
			createMenuStuff();
		} else if (chosen == newCheese) {
			Store.exactStore.addNewProductToStore(
Store.createStoreEntryInstanceCheese());
			Store.exactStore.printStore();
			createMenuStuff();
		} else if (chosen == existingCheese) {
			if (!Store.isThereAnyMilk(Store.exactStore.grocery)) {
				Store.exactStore.addExistingProduct(GetDataFromConsole.getBarCodeFromConsole());
			}
		}
		createMenuStuff();
	}

	static void drawMilkLifeSubMenu() {
		System.out.println("---=== MILK LIFE SUBMENU ===---");
		System.out.println("1 - Add LONG-LIFE milk to the stock");
		System.out.println("2 - Add SEMI-LONG-LIFE milk to the stock");

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
	
	static void milkLifeMenuLogic(int chosen) {
		final int longLife = 1;
		final int semiLongLife = 2;

		if (chosen == longLife) {
			Store.exactStore.addNewProductToStore(Store.createStoreEntryInstanceLongLife());
			createMenuStuff();
		} else if (chosen == semiLongLife) {
			Store.exactStore.addNewProductToStore(Store.createStoreEntryInstanceSemiLongLife());
			createMenuStuff();
		}
		createMenuStuff();
	}

	public static void createMenuStuff() {
		drawMainMenu();
		mainMenuLogic(mainMenuItemScanner());
	}

	private static void clearScreen() {
		// it is not working, must be solved
		System.out.print("\033[H\033[2J");
	}
	
}
