package Cheese;

import Products.Food;

public class Cheese extends Food {

	private double weight;
	private double dripping;

	public Cheese(long barCode, double weight, String warrant, double dripping, String company) {
		super(barCode, warrant, company);

		this.weight = weight;
		this.dripping = dripping;
	}

	public double getWeight() {
		return weight;
	}

	public double getDripping() {
		return dripping;
	}

	@Override
	public String toString() {
		return super.toString() + "Weight: " + weight + "\n" + "Dripping: " + dripping;
	}
}

