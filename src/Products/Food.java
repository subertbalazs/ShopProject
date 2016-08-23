package Products;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import Main.GetDataFromConsole;
import Main.Menu;
import Store.Store.StoreEntry;

public class Food {

	private long barCode;
	private String warrant;
	private String company;

	public Food(long barCode, String warrant, String company) {
		super();
		this.barCode = barCode;
		this.warrant = warrant;
		this.company = company;
	}

	public long getBarCode() {
		return barCode;
	}

	public String getWarrant() {
		return warrant;
	}

	public String getCompany() {
		return company;
	}

	public static String getWarrantyByBarCode(long barCode, Hashtable bar) {
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

	public static String returnValueTesterForGetWarrantyByConsole(String date) {
		while (date == null) {
			GetDataFromConsole.checkWarranty(GetDataFromConsole.warantyDateParser(),
					GetDataFromConsole.nowDateParser());
			Menu.createMenuStuff();
		}
		return date;
	}

	@Override
	public String toString() {
		return "BarCode: " + barCode + "\n" + "Warrant: " + warrant + "\n" + "Company: " + company + "\n";
	}

}
