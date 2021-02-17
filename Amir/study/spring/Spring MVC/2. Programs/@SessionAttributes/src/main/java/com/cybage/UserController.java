package com.cybage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/info")
	public String userInfo(@SessionAttribute("user") User user) {

		System.out.println("ID: " + user.getId());
		System.out.println("Name: " + user.getName());

		return "user";
	}
	@GetMapping("/first")
	public String first(@SessionAttribute("user") User user) {

		System.out.println("ID: " + user.getId());
		System.out.println("Name: " + user.getName());

		return "first";
	}
	@GetMapping("/second")
	public String second(@SessionAttribute("user") User user) {

		System.out.println("ID: " + user.getId());
		System.out.println("Name: " + user.getName());

		return "second";
	}
}
