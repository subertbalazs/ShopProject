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
		
		Store.addMilk();
		GetDataFromConsole.checkWarranty(GetDataFromConsole.warantyDateParser(), GetDataFromConsole.nowDateParser());
		Store.isThereAnyMilk();
		Store.buyMilk();
	}
}
