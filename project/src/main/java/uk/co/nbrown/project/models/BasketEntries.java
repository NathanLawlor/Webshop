package uk.co.nbrown.project.models;

import java.util.ArrayList;

import org.springframework.util.CollectionUtils;

public class BasketEntries {
	private ArrayList<Product> listOfProducts = new ArrayList<>();
	private double totalPrice = 0;
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
	
	public void removeProduct(Product product) {
		int productIndex = listOfProducts.indexOf(product); //always returning 0
		
		listOfProducts.remove(productIndex);
		
	}
	
	public double calculateTotalPrice () {
		totalPrice = 0;
		if (listOfProducts != null && listOfProducts.size() > 0) {
			for(int i = 0; i < listOfProducts.size(); i++) {
				totalPrice += listOfProducts.get(i).getPrice();
			}	
		}
		return totalPrice;
	}
	
	public int getBasketSize() {
		int basketSize = 0;
		if(!CollectionUtils.isEmpty(listOfProducts)) {
			basketSize = listOfProducts.size();
		}
		return basketSize;
	}
	
	public ArrayList<Product> getListOfProducts() {
		return listOfProducts;
	}
	
	public void clear() {
		listOfProducts.clear();
	}
}
