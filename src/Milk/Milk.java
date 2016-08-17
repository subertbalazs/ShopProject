package Milk;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import Main.GetDataFromConsole;
import Main.Menu;

public class Milk {

	private long barCode;
	public static final int LITER = 1000;
	public static final int HALF_LITER = 500;;
	public static final int GLASS = 250;
	public static final double WHOLE_FAT = 1.5;
	public static final double REDUCED_FAT = 2.8;

	private int capacity;
	private String warrant;
	private double dripping;
	private long price;
	private String company;

	public Milk(long barCode, int capacity, String warrant, double dripping, long price, String company) {
		super();
		this.barCode = barCode;
		this.capacity = capacity;
		this.warrant = warrant;
		this.dripping = dripping;
		this.price = price;
		this.company = company;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getWarrant() {
		return warrant;
	}

	public double getDripping() {
		return dripping;
	}

	public long getPrice() {
		return price;
	}

	public String getCompany() {
		return company;
	}

	public long getBarCode() {
		return barCode;
	}
	
	public static String getWarrantyByBarCode(long barCode, Hashtable bar) {
		Integer integerBarCode = (int) (long) barCode;
		for (Iterator<Entry<Integer, Milk>> i = bar.entrySet().iterator(); i.hasNext();) {
			Entry<Integer, Milk> entry = i.next();
			Integer key = entry.getKey();
			Milk value = entry.getValue();
			if (integerBarCode.equals(key)) {
					System.out.println("The expire date of this product is: " + value.getWarrant());
					return value.getWarrant();
				}
			}
		System.out.println("There is no product with barCode like: " + barCode + " in the stock!");
		return null;
	}

	public static String returnValueTesterForGetWarrantyByConsole(String date)
	{
		while (date == null) {
			GetDataFromConsole.checkWarranty(GetDataFromConsole.warantyDateParser(),
					GetDataFromConsole.nowDateParser());
			Menu.createMenuStuff();
		}
		return date;
	}

	public String toString() {
		return "BarCode: " + barCode + "\n" + "Capacity: " + capacity + "\n" + "Warrant: " + warrant + "\n"
				+ "Dripping: " + dripping + "\n"
				+ "Price: " + price + " " + "\n" + "Company: " + company;
	}

}
