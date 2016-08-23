package products;

public abstract class Milk extends Food {

	private int capacity;
	private double dripping;

	public Milk(long barCode, int capacity, String warrant, double dripping, String company) {
		super(barCode, warrant, company);
		this.capacity = capacity;
		this.dripping = dripping;
	}

	public int getCapacity() {
		return capacity;
	}

	public double getDripping() {
		return dripping;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Capacity: " + capacity + "\n" + "Dripping: " + dripping;
	}

}
