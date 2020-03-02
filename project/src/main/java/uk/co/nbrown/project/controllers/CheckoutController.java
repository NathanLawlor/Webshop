package uk.co.nbrown.project.controllers;

import static uk.co.nbrown.project.controllers.HomeController.productbasket;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
	/*
	 * remove basketSize/ total price
	 */
	@GetMapping(value = "/checkout")
	  public String getCheckoutPage(Model model, HttpSession HttpSession) {
			model.addAttribute("totalPrice", productbasket.getTotalPrice());
			model.addAttribute("basketSize", productbasket.getBasketSize());
	    return "pages/checkout";
	  }
}
