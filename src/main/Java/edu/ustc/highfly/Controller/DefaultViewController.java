package edu.ustc.highfly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultViewController {
	
	@RequestMapping(value = {"/index", "/"})
	public String defaultView() {
		return "index";
	}
}
