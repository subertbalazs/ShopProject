package products;

public abstract class Product {

	private long barCode;
	private String company;

	public Product(long barCode, String company) {
		super();
		this.barCode = barCode;
		this.company = company;
	}

	public long getBarCode() {
		return barCode;
	}

	public String getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "BarCode: " + barCode + "\n" + "Company: " + company;
	}

}
