package edu.ustc.highfly.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ustc.highfly.Dao.UserDao;
import edu.ustc.highfly.Model.User;

@Controller
public class savePersonalInformationController {
	@Autowired
	private UserDao ud;
	
	@RequestMapping(value = "/savePersonalInformation", method = RequestMethod.POST)
	@ResponseBody
	public String savePersonalInformation(HttpServletRequest request, HttpSession session) {
		String email = (String) session.getAttribute("email");
//		System.out.println(email);
		User u = ud.getUserByEmail(email);
		
		String name = request.getParameter("sname");
		String studentId = request.getParameter("sid");
		String sex = getSex(request.getParameter("sex"));
		
		u.setName(name);
		u.setStudentId(studentId);
		u.setGender(sex);
		
		ud.updateByEmail(u, email);
		return "Modify successfully";
	}
	
	private String getSex(String sid) {
		if(sid.equals("0")) {
			return "男";
		}else if(sid.equals("1")) {
			return "女";
		}else 	return "保密";
	}
}
