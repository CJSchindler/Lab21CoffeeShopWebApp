package co.grandcircus.coffeeshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage() {
		// parameter inside the constructor represents the jsp file we create
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	@RequestMapping("/summary")
	public ModelAndView showRegistrationPage(@RequestParam("firstname") String firstname, 
			@RequestParam("lastname") String lastname,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("firstname", firstname);
		mav.addObject("lastname", lastname);
		mav.addObject("email", email);
		mav.addObject("phone", phone);
		mav.addObject("password", password);
		return mav;
	}
	
}
