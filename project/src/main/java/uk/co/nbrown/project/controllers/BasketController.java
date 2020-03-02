package uk.co.nbrown.project.controllers;

import static uk.co.nbrown.project.controllers.HomeController.productbasket;
import static uk.co.nbrown.project.controllers.HomeController.BASKET_KEY;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.nbrown.project.models.Product;
import uk.co.nbrown.project.models.ProductBasket;
import uk.co.nbrown.project.repositories.ProductRepository;

@Controller
public class BasketController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/basket")
	public String getCutomerBasketPage(Model model, HttpSession HttpSession) {
		if(HttpSession.getAttribute(BASKET_KEY) != null) {
			productbasket = (ProductBasket) HttpSession.getAttribute(BASKET_KEY);
			model.addAttribute("basket", productbasket.getBasketEntries());
		}
		model.addAttribute("basketSize", productbasket.getBasketSize());
		return "pages/basket";
	  }	
	
	@PostMapping(value = "/addProductToBasket")
	@ResponseBody
	public ProductBasket addProductToBasket(Model model, HttpSession HttpSession, @RequestParam int productID) { 
		List <Product> productSearch = productRepository.findById(productID); //returns a list from the search
		Product item = productSearch.remove(0); //returns first item in the list
		
		//if the session has a basket then the attribute will be updated with the new basket
		if(HttpSession.getAttribute(BASKET_KEY) != null) {  
			productbasket = (ProductBasket) HttpSession.getAttribute(BASKET_KEY);
			
			productbasket.addProductToBasket(item);	
			
			HttpSession.setAttribute(BASKET_KEY, productbasket);
			
			return productbasket;
		}
		else { //if the session doesnt have a basket then a basket will be created and added to the session
			ProductBasket tempBasket = new ProductBasket();
			tempBasket.addProductToBasket(item);
			HttpSession.setAttribute(BASKET_KEY, tempBasket);
			return productbasket;
		}
	}
	
	@PostMapping(value = "/removeProductFromBasket")
	@ResponseBody
	public void removeproductFromBasket(HttpSession HttpSession, @RequestParam int productID) {
		List <Product> productSearch = productRepository.findById(productID); //returns a list from the search
		Product item = productSearch.remove(0); //returns first item in the list
		
		productbasket = (ProductBasket) HttpSession.getAttribute(BASKET_KEY);
		productbasket.removeProductFromBasket(item);
		
		HttpSession.setAttribute(BASKET_KEY, productbasket);
	}
}
