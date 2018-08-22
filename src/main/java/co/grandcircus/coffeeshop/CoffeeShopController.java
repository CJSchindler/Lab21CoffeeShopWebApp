package co.grandcircus.coffeeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private ItemsDao itemsDao;

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
		
		//construct a new user from the URL params
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("user", user);
		return mav;
	}
	
}
