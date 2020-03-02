package uk.co.nbrown.project.controllers;

import static uk.co.nbrown.project.controllers.HomeController.BASKET_KEY;
import static uk.co.nbrown.project.controllers.HomeController.productbasket;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uk.co.nbrown.project.models.ProductBasket;

@Controller
public class LoginController {
	@GetMapping(value = "/login")
	public String getLoginPage(Model model, HttpSession HttpSession) {
		if (HttpSession.getAttribute(BASKET_KEY) != null) {
			productbasket = (ProductBasket) HttpSession.getAttribute(BASKET_KEY);
			model.addAttribute("basket", productbasket.getBasketEntries());
		}
		model.addAttribute("basketSize", productbasket.getBasketSize());
		return "pages/login";
	}
	
	@GetMapping(value = "/loggedin")
	public String redirectToProductPage(HttpSession HttpSession) {
		if(HttpSession.getAttribute(BASKET_KEY) != null) { }
		else {
			ProductBasket productBasket = new ProductBasket();
			HttpSession.setAttribute(BASKET_KEY, productBasket);
		}
		
		return "redirect:productPage";
	}
}
 