package com.cybage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")		//class level request mapping
public class AdminController {

	//request param
	//	@RequestMapping("/admin")
	//	@ResponseBody
	//	public String getHome(@RequestParam int id ) {
	//		return "we got value: "+ id;
	//	}

	//naming request param
	//	@RequestMapping("/admin")
	//	@ResponseBody
	//	public String getHome(@RequestParam("id") int userid ) {
	//		return "we got value:  : "+ userid;
	//	}


	//optional request param
	//	@RequestMapping("/admin")
	//	@ResponseBody
	//	public String getHome(@RequestParam(name = "id", required = true) String userid ) {
	//		return "we got value:  : "+ userid;
	//	}

	//optional request param
	//	@RequestMapping("/admin")
	//	@ResponseBody
	//	public String getHome(@RequestParam(name = "id", required = true, defaultValue = "cybage101") String userid ) {
	//		return "we got value:  : "+ userid;
	//	}

	//mapping all params
	//http://localhost:8081/1.first/admin/admin?id=101&name=dm&address=pune
	//	@RequestMapping("/admin")
	//	@ResponseBody
	//	public String getHome(@RequestParam Map<String, String> allParams ) {
	//		return "we got value:  : "+ allParams;
	//	}

	//mapping multiple value
	//http://localhost:8081/1.first/admin/admin?id=101,102, 103
	//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	//	@ResponseBody
	//	public String getHome(@RequestParam(name = "id") List<String> allParams ) {
	//		return "we got value:  : "+ allParams;
	//	}

	

}