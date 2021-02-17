package com.cybage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/addNew")
@SessionAttributes("employee")
public class EmpController 
{
        
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) 
    {
         Employee employee = new Employee();
         model.addAttribute("employee", employee);
         return "addEmployee";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("employee") Employee employee,
                            BindingResult result, SessionStatus status) 
    {
        //Validation code start
        boolean error = false;
         
        System.out.println(employee); //Verifying if information is same as input by user
         
        if(employee.getFirstName().isEmpty()){
            result.rejectValue("firstName", "error.firstName");
            error = true;
        }
         
        if(employee.getLastName().isEmpty()){
            result.rejectValue("lastName", "error.lastName");
            error = true;
        }
         
        if(employee.getEmail().isEmpty()){
            result.rejectValue("email", "error.email");
            error = true;
        }
         
        if(error) {
            return "addEmployee";
        }
        //validation code ends
         
        //Store the employee information in database
         
        //Mark Session Complete
        status.setComplete();
        return "redirect:addNew/success";
    }
     
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model) 
    {
         return "addSuccess";
    }
}