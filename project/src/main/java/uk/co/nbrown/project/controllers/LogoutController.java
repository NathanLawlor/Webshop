package uk.co.nbrown.project.controllers;

import static uk.co.nbrown.project.controllers.HomeController.productbasket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	@GetMapping(value = "/loggedout")
	public String getLogoutPage(Model model) {
		productbasket.emptyBasket();
		
		model.addAttribute("basketSize", productbasket.getBasketSize());
		return "pages/logout";
	}
}
