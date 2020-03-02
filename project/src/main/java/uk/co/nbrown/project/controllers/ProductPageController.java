package uk.co.nbrown.project.controllers;

import static uk.co.nbrown.project.controllers.HomeController.productbasket;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uk.co.nbrown.project.repositories.ProductRepository;

@Controller
public class ProductPageController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/productPage")
	  public String getProductPage(Model model, HttpSession HttpSession) {		
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("basketSize", productbasket.getBasketSize());
		return "pages/productPage";
	  }
	
	@GetMapping(value = "productPage/{productID}")
	public String getSelectedProductViewPage(Model model, HttpSession HttpSession, @PathVariable(value="productID") int itemID) { 
	  	model.addAllAttributes(productRepository.findById(itemID));
		model.addAttribute("basketSize", productbasket.getBasketSize());
	  	return "pages/selectedProductView";
  }
}
