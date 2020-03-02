package uk.co.nbrown.project.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uk.co.nbrown.project.models.ProductBasket;

@Controller
public class HomeController { 
	public static final String BASKET_KEY = "productBasket";
	public static ProductBasket productbasket = new ProductBasket();
	
	@GetMapping(value = {"/home","/"} )
	  public String getHomepage(Model model, HttpSession HttpSession) {
		model.addAttribute("basketSize", productbasket.getBasketSize());
	    return "pages/home";
	  }
	
//	@GetMapping(value = {"/home","/"} )
//	  public ModelAndView home(Model model, HttpSession HttpSession) {
//		model.addAttribute("basketSize", productbasket.getBasketSize());
//	    return new ModelAndView("pages/home");
//	  }
}