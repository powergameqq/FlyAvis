package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import services.AccountService;
import services.TripService;
@EnableWebMvc
@Controller
public class BasicController {
	@Autowired
	AccountService as;
	@Autowired
	TripService ts;
	@RequestMapping("/")
	public String showIndex(Model model) {
		return "index";
	}
	@RequestMapping("/test")
	public String editDataTest(Model model) {
		return "test";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	@RequestMapping("/build")
	public String build(Model model) {
		return "build";
	}
	@RequestMapping("/myTravel")
	public String myTravel(Model model) {
		System.out.println("即將進入myTravel頁面");
		return "myTravel";
	}
	@RequestMapping("/myBill")
	public String myBill(Model model) {
		System.out.println("即將進入myBill頁面");
		return "myBill";
	}
	@RequestMapping("/aboutMe")
	public String aboutMe(Model model) {
		return "aboutMe";
	}
	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}
	@RequestMapping("/logout")
	public String logout(Model model) {
		return "logout";
	}
}
