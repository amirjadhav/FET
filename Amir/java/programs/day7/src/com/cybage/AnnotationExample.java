package com.cybage;

 

@MyAnnotation
public class AnnotationExample {
    
    @MyAnnotation
    private int prop;
    
    @MyAnnotation
    public AnnotationExample() {
        System.out.println("this is constructor");
    }
    
    @MyAnnotation
    public static void main(@MyAnnotation String[] args) {
        System.out.println("annotation example");
        @MyAnnotation(address = "mumbai", salary = 12345)
        @SuppressWarnings("unused")
        int a = 10;
    }
}