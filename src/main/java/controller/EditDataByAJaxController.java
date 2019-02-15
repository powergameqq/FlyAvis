package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.Member;
import model.MyTrip;
import services.AccountService;
import services.TripService;

@RestController
@EnableWebMvc
@RequestMapping("/editData")
public class EditDataByAJaxController {
	@Autowired
	AccountService as;
	@Autowired
	TripService ts;
	
	@RequestMapping(value="/checkAccount",consumes = "application/json")
	public String editDataTest(@RequestBody Member mem) {
		int newId;
		System.out.println("收到資料，UID="+mem.getUserId());
		Member checkedMember =as.checkAccount(mem);
		if(checkedMember != null) {
			newId = checkedMember.getUserId();
		}else {
			newId = as.createAccount(mem);
		}
		return ""+newId;
	}
	
	@RequestMapping(value="/updateAccount",consumes = "application/json")
	public <T>T updateDataTest(@RequestBody T t) {
		ts.update(t);
		return t;
	}
	@RequestMapping(value="/createTravel",consumes = "application/json")
	public String createTravel(@RequestBody MyTrip myTrip) {
		
		int newId = 0;
		System.out.println("收到資料，UID="+myTrip.getTripName());
		newId =ts.create(myTrip);
			return ""+newId;
	}
}
