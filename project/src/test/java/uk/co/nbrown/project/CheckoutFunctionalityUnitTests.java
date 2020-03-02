package uk.co.nbrown.project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.nbrown.project.models.Product;
import uk.co.nbrown.project.models.ProductBasket;

public class CheckoutFunctionalityUnitTests {

	private ProductBasket mockBasket;
	private Product mockProductA;
	private Product mockProductB;
	private Product mockProductC;
	private Product mockProductD;
	
	@Before //this is called ~before each test is executed
	public void setUp() {
		mockBasket = new ProductBasket();
		mockProductA = new Product("A", "aaa",  5.00, "/");
		mockProductB = new Product("B", "bb", 10.00, "/");
		mockProductC = new Product("C", "ccc", 15.00, "/");
		mockProductD = new Product("D", "ddd", 20.00, "/");
	}
	
	@Test
	public void totalPriceShouldBeZeroWithEmptyBasketTest() {
		Assert.assertTrue(mockBasket.getTotalPrice() == 0.0); //default total price when the basket is empty
	}
	
	@Test
	public void totalPriceShouldBeCorrectTest() {
		mockBasket.addProductToBasket(mockProductA);
		mockBasket.addProductToBasket(mockProductB);
		mockBasket.addProductToBasket(mockProductC);
		
		Assert.assertTrue(mockBasket.getTotalPrice() == 30.00); //5 + 10 + 15 = 30
		
		mockBasket.removeProductFromBasket(mockProductB); //- 10
		
		Assert.assertTrue(mockBasket.getTotalPrice() == 20.00); //5 + 15 = 20
		
		mockBasket.addProductToBasket(mockProductD); //+ 20
		
		Assert.assertTrue(mockBasket.getTotalPrice() == 40.00); //5 + 15 + 20 = 40
	}
}
