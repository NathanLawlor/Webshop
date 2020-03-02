package uk.co.nbrown.project.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.nbrown.project.models.Product;
import uk.co.nbrown.project.models.ProductBasket;

public class BasketEntriesTest {
	
	private static final String PRODUCT_A_NAME = "A";
	
	private ProductBasket productBasket;
	private Product productA;
	private Product productB;

	@Before //this is called ~before each test is executed
	public void setUp() {
		productBasket = new ProductBasket();
		productA = new Product(PRODUCT_A_NAME, "aaa", 10.00, "/");
		productB = new Product("B", "bbb", 10.00, "/");
	}
	
	@Test
	public void basketSizeShouldBeZeroWhenBasketIsEmptyTest() {
		Assert.assertEquals(0, productBasket.getBasketSize());
	}
	
	@Test
	public void addProductToBasketTest() {	
		Assert.assertEquals(0 , productBasket.getBasketSize());
		productBasket.addProductToBasket(productA);
		Assert.assertEquals(1, productBasket.getBasketSize());
	}
	
	@Test
	public void removingProductFromBasketTest() {
		productBasket.addProductToBasket(productA); //populate basket with a product
		Assert.assertEquals(1 , productBasket.getBasketSize());
		Assert.assertEquals(PRODUCT_A_NAME, productBasket.getBasketEntries().get(0).name);
		
		productBasket.removeProductFromBasket(productA); //remove the product from the basket
		Assert.assertEquals(0 , productBasket.getBasketSize());	
	}
	
	@Test
	public void productShouldExistInBasketTest() {
		productBasket.addProductToBasket(productA);
		Assert.assertTrue(productBasket.getBasketEntries().contains(productA));
	}
	
	@Test
	public void productShouldNotExistInBasketTest() {
		Assert.assertFalse(productBasket.getBasketEntries().contains(productA));
	}
	
	@Test
	public void clearingBasketEntriesTest() {
		productBasket.addProductToBasket(productA);
		productBasket.addProductToBasket(productB); //populate basket with two products
		
		Assert.assertEquals(2 , productBasket.getBasketSize());
		
		productBasket.emptyBasket(); // clear the basket entries
		
		Assert.assertEquals(0 , productBasket.getBasketSize());
	}
}
