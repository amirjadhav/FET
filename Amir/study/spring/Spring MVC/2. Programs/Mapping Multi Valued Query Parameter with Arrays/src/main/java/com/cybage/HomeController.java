package com.cybage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController { 
	
	@RequestMapping("/items")			//http://localhost:8087/spring-mvc/items?id=101, 102
    public @ResponseBody String handleRequest(@RequestParam("id") String[] itemIds) {
        String response = "";
        for (String itemId : itemIds) {
            response += "item with string id " + itemId + "<br/>";
        }
        return response;
    }
    @RequestMapping("/items2")		//http://localhost:8087/spring-mvc/items2?id=101,102
    public  @ResponseBody String handleRequest2(@RequestParam("id") int[] itemIds) {
        String response = "";
        for (int itemId : itemIds) {
            response += "item with int id " + itemId + "<br/>";
        }
        return response;
    }
    @RequestMapping("/items3")	//http://localhost:8087/spring-mvc/items3?id=102,103, 23423, 234234&name=dm, dm1, dm3
    public @ResponseBody String handleRequest3(@RequestParam MultiValueMap<String, String> queryMap) {
        String response = "";
        System.out.println(queryMap);
        List<String> itemIds = queryMap.get("id");
        for (String itemId : itemIds) {
            response += "item from map with String id " + itemId + "<br/>";
        }
        return response;
    }
}

