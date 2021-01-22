package com.cybage;



public class UI {
    public static void main(String[] args) {
        System.out.println("employee demo...");
        
        EmployeeService empService = new EmployeeServieImpl();
        
        try {
            //add one regular employee
            empService.add("101", "Pune", 123, "REG");            
        }catch(EmployeeException ee) {
            System.err.println(ee.getLocalizedMessage());
        }
        
        try {
            //add one retired employee
            empService.add("102", "Solapur", 789, "RET");            
        }catch(EmployeeException ee) {
            System.err.println(ee.getLocalizedMessage());
        }
        
        empService.display();
        System.out.println("-------------------------------------");
        empService.display();
        System.out.println("-------------------------------------");
        System.out.println("Deleting element of id: 101" );
        empService.delete(101);
        empService.display();
        
    }
}