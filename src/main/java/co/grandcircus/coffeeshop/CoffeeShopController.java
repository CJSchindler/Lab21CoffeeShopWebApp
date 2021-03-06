package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.entity.Item;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		List<Item> items = itemsDao.findAll();
		ModelAndView mav = new ModelAndView("index", "items", items);
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
		
		userDao.create(user);
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/add-item")
	public ModelAndView addItem() {
		return new ModelAndView("add-item");
	}
	
	
	@RequestMapping("/items/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		itemsDao.delete(id);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/edit-item/{id}")
	public ModelAndView showEditForm(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("edit-item"); //goes to form to edit item
		mav.addObject("item", itemsDao.findById(id));
		mav.addObject("name", "Edit Item");
		return mav;
	}
	
	@RequestMapping(value="/submit-add", method=RequestMethod.POST)
	public ModelAndView create(@RequestParam("name") String name, 
			@RequestParam("description") String description, 
			@RequestParam("quantity") int quantity, 
			@RequestParam("price") float price) {
		
		Item item = new Item (name, description, quantity, price);
		itemsDao.create(item);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/submit-add-user", method=RequestMethod.POST)
	public ModelAndView createUser(@RequestParam("firstname") String firstname, 
			@RequestParam("lastname") String lastname, 
			@RequestParam("email") String email, 
			@RequestParam("phone") String phone,
			@RequestParam("password") String password) {
		
		User user = new User (firstname, lastname, email, phone, password);
		userDao.create(user);
		return new ModelAndView("redirect:/");
	}
//	
//	@RequestMapping("item/{id}")
//	public ModelAndView showItem(@PathVariable("id") Integer id) {
//		ModelAndView mav = new ModelAndView("details");
//		mav.addObject("item", itemsDao.findById(id));
//		return mav;
//	}
	
}
