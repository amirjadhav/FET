package com.cybage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

	@GetMapping("/user/{firstName}/{lastName}")
	@ResponseBody
	public String handler(@MatrixVariable("firstName") String firstName,
			@MatrixVariable("lastName") String lastName
			) {
		return "firstName =" + firstName +"<br>"
				+ "lastName =" + lastName;
	}
}
