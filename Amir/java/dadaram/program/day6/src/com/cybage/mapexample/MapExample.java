package com.cybage.mapexample;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import day6.Product;

public class MapExample {
	public static void main(String[] args) {
		System.out.println("map example...");
		//Map<String, String> capitals = new HashMap<>();
		Map<String, String> capitals = new TreeMap<>(Collections.reverseOrder());
		
		
		//Map<String, Long> population = new HashMap<>();
		//Map<String, Long> population = new LinkedHashMap<>();
		//Map<String, Long> population = new TreeMap<>();
		//Map<String, Long> population = new Hashtable<>();
		
		capitals.put("MH", "mumbai");
		capitals.put("GJ", "gandhinagar");
		capitals.put("TL", "hyderabad");
		capitals.put("AP", "hyderabad");
		capitals.put("TN", "chennai");
		capitals.put("PB", "chandigarh");
		capitals.put("HN", "chandigarh");
		capitals.put("MH", "pune");
		capitals.put("Delhi", null);
		capitals.put("MP", null);
		
		
		System.out.println(capitals);
		
		//get only keys
		Set<String> state = capitals.keySet();
		System.out.println(state);
		
		//get only values
		Collection<String> capital = capitals.values();
		System.out.println(capital);
		
		
	}
}
