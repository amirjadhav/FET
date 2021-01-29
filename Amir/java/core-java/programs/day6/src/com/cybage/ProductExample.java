package com.cybage;

import java.util.Set;
import java.util.TreeSet;

 

public class ProductExample {
    public static void main(String[] args) {
        //Set<Product> products = new HashSet<>();
        Set<Product> products = new TreeSet<>(new IdComparator());
        
        products.add(new Product(101, "computer", 35000, 15));
        products.add(new Product(102, "laptop", 45000, 10));
        products.add(new Product(103, "printer", 12000, 5));
        products.add(new Product(104, "server", 150000, 2));
        products.add(new Product(105, "scanner", 5000, 1));
        products.add(new Product(101, "computer", 35000, 15));
        
        System.out.println(products);
    }
}