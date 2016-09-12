package Main;

import java.util.Scanner;

import store.Store;

public class Menu {

	static void drawMainMenu() {
		System.out.println("\n---=== MENU ===---");
		System.out.println("1 - Add new Store");
		System.out.println("2 - Inventory changes");
		System.out.println("3 - Delete store");
	}
	
	static int mainMenuItemScanner() {
		@SuppressWarnings("resource")
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
			Store.addStoreToList(Store.createStoreInstance(), Store.storeList);
			Store.getStoreList();
			createMenuStuff();

		} else if (chosen == fillStore) {
			if (!Store.isTheStoreListEmpty(Store.storeList)) {
				Store.getStoreList();
				Store.getStoreByName(Store.storeList);
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
		System.out.println("\n---=== Inventrory changes: " + "'" + Store.exactStore.getName() + "'" + " store ===---");
		System.out.println("1 - Open/Close " + "'" + Store.exactStore.getName() + "'" + "shop");
		System.out.println("2 - Add food to the " + "'" + Store.exactStore.getName() + "'" + "stock");
		System.out.println("3 - Is there any product in the " + "'" + Store.exactStore.getName() + "'" + "stock?");
		System.out.println("4 - Buy something from " + "'" + Store.exactStore.getName() + "'");
		System.out.println("5 - Check warranty of a product from " + "'" + Store.exactStore.getName() + "'");
		System.out.println("6 - Back to Main Menu");
	}
	
	static int storeMenuItemScanner() {

		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int minimumMenuItem = 0;
		int maximumMenuItem = 6;
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
		final int openClose = 1;
		final int addFood = 2;
		final int isThereMilk = 3;
		final int buyMilk = 4;
		final int checkWarranty = 5;
		final int main = 6;
		
		if (chosen == openClose) {
			Store.exactStore.openCloseExactShop();
			drawStoreMenu();
			storeMenuLogic(storeMenuItemScanner());
		} else if (chosen == addFood) {
			if (!Store.exactStore.isClosed()) {
				drawAddFoodSubMenu();
				addFoodSubMenuLogic(addFoodSubMenuItemScanner());
			}
			System.out.println("You have to open the shop first. (Use menu item: 1.)");
			drawStoreMenu();
			storeMenuLogic(storeMenuItemScanner());
		} else if (chosen == isThereMilk) {
			if (!Store.exactStore.isClosed()) {
				Store.isTheGroceryEmpty(Store.exactStore.grocery);
				createMenuStuff();
			}
			System.out.println("You have to open the shop first. (Use menu item: 1.)");
			drawStoreMenu();
			storeMenuLogic(storeMenuItemScanner());
		} else if (chosen == buyMilk) {
			if (!Store.exactStore.isClosed()) {
				if (!Store.isTheGroceryEmpty(Store.exactStore.grocery)) {
					Store.buyProduct(GetDataFromConsole.getBarCodeFromConsole(), Store.exactStore.grocery);
				}
				createMenuStuff();
			}
			System.out.println("You have to open the shop first. (Use menu item: 1.)");
			drawStoreMenu();
			storeMenuLogic(storeMenuItemScanner());
		} else if (chosen == checkWarranty) {
			if (!Store.exactStore.isClosed()) {
				if (!Store.isTheGroceryEmpty(Store.exactStore.grocery)) {
					GetDataFromConsole.checkWarranty(Store.warantyDateParser(), GetDataFromConsole.nowDateParser());
					createMenuStuff();
				}
			}
			System.out.println("You have to open the shop first. (Use menu item: 1.)");
			drawStoreMenu();
			storeMenuLogic(storeMenuItemScanner());
		} else if (chosen == main) {
			createMenuStuff();
		}
		createMenuStuff();
	}
	
	public static void drawAddFoodSubMenu() {
		System.out.println("\n---=== ADD FOOD SUBMENU ===---");
		System.out.println("1 - Add MILK to the stock with NEW barcode");
		System.out.println("2 - Add MILK to the stock with EXISTING barcode");
		System.out.println("3 - Add CHEESE to the stock with NEW barcode");
		System.out.println("4 - Add CHEESE to the stock with EXISTING barcode");
		System.out.println("5 - Back to Main Menu");
		
	}

	public static int addFoodSubMenuItemScanner() {

		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int minimumMenuItem = 0;
		int maximumMenuItem = 5;
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
		final int main = 5;
		
		if (chosen == newMilk) {
			drawMilkLifeSubMenu();
			milkLifeMenuLogic(addFoodSubMenuItemScanner());
		} else if (chosen == existingMilk) {
			if (!Store.isTheGroceryEmpty(Store.exactStore.grocery)) {
				Store.exactStore.addExistingProduct(GetDataFromConsole.getBarCodeFromConsole());
			}
			createMenuStuff();
		} else if (chosen == newCheese) {
			Store.exactStore.addNewProductToStore(
Store.createStoreEntryInstanceCheese());
			Store.exactStore.printStore();
			createMenuStuff();
		} else if (chosen == existingCheese) {
			if (!Store.isTheGroceryEmpty(Store.exactStore.grocery)) {
				Store.exactStore.addExistingProduct(GetDataFromConsole.getBarCodeFromConsole());
			}
		} else if (chosen == main) {
			createMenuStuff();
		}
		createMenuStuff();
	}

	static void drawMilkLifeSubMenu() {
		System.out.println("\n---=== MILK LIFE SUBMENU ===---");
		System.out.println("1 - Add LONG-LIFE milk to the stock");
		System.out.println("2 - Add SEMI-LONG-LIFE milk to the stock");
		System.out.println("3 - Back to Main Menu");

	}

	static int milkLifeSubMenuItemScanner() {

		@SuppressWarnings("resource")
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
	
	static void milkLifeMenuLogic(int chosen) {
		final int longLife = 1;
		final int semiLongLife = 2;
		final int main = 3;

		if (chosen == longLife) {
			Store.exactStore.addNewProductToStore(Store.createStoreEntryInstanceLongLife());
			createMenuStuff();
		} else if (chosen == semiLongLife) {
			Store.exactStore.addNewProductToStore(Store.createStoreEntryInstanceSemiLongLife());
			createMenuStuff();
		} else if (chosen == main) {
			createMenuStuff();
		}
		createMenuStuff();
	}

	public static void createMenuStuff() {
		drawMainMenu();
		mainMenuLogic(mainMenuItemScanner());
	}
}
