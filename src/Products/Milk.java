package products;

public abstract class Milk extends Food {

	public static final int LITER = 1000;
	public static final int HALF_LITER = 500;;
	public static final int GLASS = 250;
	public static final double WHOLE_FAT = 1.5;
	public static final double REDUCED_FAT = 2.8;

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
