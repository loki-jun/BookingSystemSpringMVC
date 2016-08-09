package edu.ustc.highfly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class BookingMainController {
	@RequestMapping(value = "/bookingMain")
	public String bookingMainView() {
		return "booking_main";
	}
	
	
}
