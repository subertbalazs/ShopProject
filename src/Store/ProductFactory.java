package store;

import Main.GetDataFromConsole;
import products.Cheese;
import products.LongLifeMilk;
import products.SemiLongLifeMilk;

public class ProductFactory {

	public static LongLifeMilk createLongLifeMilkInstance() {
		LongLifeMilk milkObjectLL = new LongLifeMilk(GetDataFromConsole.getBarCodeFromConsole(),
				GetDataFromConsole.getCapacityFromConsole(), GetDataFromConsole.getExpireDateFromConsole(),
				GetDataFromConsole.getDrippingFromConsole(), GetDataFromConsole.getCompanyFromConsole());
		return milkObjectLL;
	}

	public static SemiLongLifeMilk createSemiLongLifeMilkInstance() {
		SemiLongLifeMilk milkObjectSLL = new SemiLongLifeMilk(GetDataFromConsole.getBarCodeFromConsole(),
				GetDataFromConsole.getCapacityFromConsole(), GetDataFromConsole.getExpireDateFromConsole(),
				GetDataFromConsole.getDrippingFromConsole(), GetDataFromConsole.getCompanyFromConsole());
		return milkObjectSLL;
	}

	
	 public static Cheese createCheeseInstance() {
		Cheese cheeseObj = new Cheese(GetDataFromConsole.getBarCodeFromConsole(),
				GetDataFromConsole.getWeightFromConsole(), GetDataFromConsole.getExpireDateFromConsole(),
				GetDataFromConsole.getDrippingFromConsole(), GetDataFromConsole.getCompanyFromConsole());
		return cheeseObj;
	}

}
