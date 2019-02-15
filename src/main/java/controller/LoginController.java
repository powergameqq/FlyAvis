package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.Member;
import services.AccountService;
import services.TripService;

@EnableWebMvc
@RestController
public class LoginController {
	@Autowired
	AccountService as;
	@Autowired
	TripService ts;

	@RequestMapping(value="/checkUserToken",consumes = "application/json")
	public String checkUserToken(@RequestBody Member mem,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String requestURI = (String) session.getAttribute("requestURI");
		Member mb = null;
//		int uem;
		mb = as.checkUserToken(mem);
		session.setAttribute("LoginOK", mb);
		System.out.println(mb.getUserToken()+"登入成功");
//		uem = mb.getUserId();
		if (requestURI != null) {
			String path = requestURI.substring(requestURI.lastIndexOf("/")+1);
			System.out.println(path);
			return path;
		} else {
			return "index";
		}
		
	}
}
