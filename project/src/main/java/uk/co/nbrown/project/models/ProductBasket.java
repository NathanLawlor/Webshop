package uk.co.nbrown.project.models;

import java.util.ArrayList;

public class ProductBasket {
	private BasketEntries basketEntries = new BasketEntries();
	
	public void addProductToBasket(Product product) {
		basketEntries.addProduct(product);
	}

	public void removeProductFromBasket(Product product) {
		basketEntries.removeProduct(product);
	}
	
	public ArrayList<Product> getBasketEntries() {
		return basketEntries.getListOfProducts();
	}
	
	public int getBasketSize() {
		return basketEntries.getBasketSize();
	}
	
	public double getTotalPrice() {	
		return basketEntries.calculateTotalPrice();
	}
	
	public void emptyBasket() {
		basketEntries.clear();
	}
}
