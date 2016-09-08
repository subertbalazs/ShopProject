package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import products.LongLifeMilk;
import products.Milk;
import products.Product;

public class TestProduct {

	@Test
	public void test_getBarCode_ReturnTrue_inCaseOfCorrectValue() {
		Product product = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		long barCode = 1111;
		long result = product.getBarCode();
		assertTrue(result == barCode);
	}

	@Test
	public void test_getBarCode_ReturnFalse_inCaseOfIncorrectValue() {
		Product product = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		long barCode = 1000;
		long result = product.getBarCode();
		assertFalse(result == barCode);
	}

	@Test
	public void test_getCompany_ReturnTrue_inCaseOfCorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		String company = "test";
		String result = milk.getCompany();
		assertEquals(result, company);
	}

	@Test
	public void test_getCompany_ReturnFalse_inCaseOfIncorrectValue() {
		Milk milk = new LongLifeMilk(1111, 1000, "1999-11-11", 1, "test");
		String company = "testes";
		String result = milk.getCompany();
		assertFalse(result.equals(company));
	}
}
