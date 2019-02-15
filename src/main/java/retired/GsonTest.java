package retired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import model.Bill;


public class GsonTest {
	
	 public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("retired\\applicationContext.xml");
	
	Gson gson = new Gson();
		
	Bill bill =(Bill)ctx.getBean("bill");
	bill.setCostTittle("no reason");
	bill.setSingleCost(300);
	String s = gson.toJson(bill);
	System.out.println(s);
	Bill bill2 = gson.fromJson(s, Bill.class);
	System.out.println(bill2.getCostId());
	 }
}
