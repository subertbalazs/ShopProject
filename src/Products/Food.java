package products;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import Main.GetDataFromConsole;
import Main.Menu;
import store.Store;
import store.Store.StoreEntry;

public abstract class Food extends Product {


	private String warrant;


	public Food(long barCode, String warrant, String company) {
		super(barCode, company);

		this.warrant = warrant;
	}

	public String getWarrant() {
		return warrant;
	}

	public static String getWarrantyByBarCode(long barCode, Hashtable<Integer, StoreEntry> bar) {
		Integer integerBarCode = (int) (long) barCode;
		for (Iterator<Entry<Integer, StoreEntry>> i = bar.entrySet().iterator(); i.hasNext();) {
			Entry<Integer, StoreEntry> entry = i.next();
			Integer key = entry.getKey();
			StoreEntry value = entry.getValue();
			if (integerBarCode.equals(key)) {
				System.out.println("The expire date of this product is: " + value.getMilk().getWarrant());
				return value.getMilk().getWarrant();
			}
		}
		System.out.println("There is no product with barCode like: " + barCode + " in the stock!");
		return null;
	}

	// If the getWarrantyByConsole return null there will be an exception to
	// avoid this
	// I use this method.
	public static String returnValueTesterForGetWarrantyByConsole(String date) {
		while (date == null) {
			GetDataFromConsole.checkWarranty(Store.warantyDateParser(),
					GetDataFromConsole.nowDateParser());
			Menu.createMenuStuff();
		}
		return date;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Warrant: " + warrant + "\n";
	}

}
