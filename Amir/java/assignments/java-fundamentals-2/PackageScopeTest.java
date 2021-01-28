//Write a program to demonstrate package scope

import user.PackageTest;
public class PackageScopeTest {
      public static void main(String[] args) {
       PackageTest packageTest = new PackageTest();
       System.out.println(packageTest.a);
    //    System.out.println(packageTest.b);   // cannot access b as it is protected in class
    //    System.out.println(packageTest.c);    // cannot access b as it is private in class
        
    }
}
