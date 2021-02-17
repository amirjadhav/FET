package com.cybage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

 
@Controller
@SessionAttributes("user")
public class LoginController {

   @ModelAttribute("user")
   public User setUpUserForm() {
      return new User();
   }
 
   @GetMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/dologin")
   public String doLogin(@ModelAttribute("user") User user, Model model) {

      if (user.getId() == 101 && user.getName().equals("dmjadhav")) {
    	  user.setId(102);
    	  user.setName("dm");
    	  
      } else {
         model.addAttribute("message", "Login failed. Try again.");
         return "index";
      }
      return "success";
   }
}