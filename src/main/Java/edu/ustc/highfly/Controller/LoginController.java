package edu.ustc.highfly.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ustc.highfly.Dao.UserDao;
import edu.ustc.highfly.Model.User;

@Controller
//@RequestMapping("/BookingSystemSpringMVC")
public class LoginController {
	@Autowired
	private UserDao ud;
		
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
//		return "hellp";
		User u = ud.getUserByEmail(email);
		
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		
		String forward;
		if(u != null && password.equals(u.getPassword())) {
			forward = "/bookingMain";
		}else {
			forward = "/error";
		}
		
		return "forward:" + forward;
	}
	
	@RequestMapping("/Register")
	public String register(@RequestParam("email") String email, @RequestParam("password") String password) {
		User u = new User(email, password);
		ud.add(u);
		
		return "forward:/index";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "success";
	}
}
