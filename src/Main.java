public class Main {

	public static String test;

	public static void main(String[] args) {
		Milk mizo = new Milk(1, Milk.getExpireDateFromConsole(), 1.5, 280, "Mizo Csodafarm");
		System.out.println(mizo);
		Milk.checkWarranty(Milk.warantyDateParser(), Milk.nowDateParser());
	}

}
