package com.cybage;

 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 

public class UserExample {
    public static void main(String[] args) {
        System.out.println("user example");
        List<User> users = new ArrayList<>();
        
        users.add(new User(101, "zdm101"));
        users.add(new User(102, "xdm102"));
        users.add(new User(105, "ydm105"));
        users.add(new User(103, "adm103"));
        users.add(new User(104, "bdm104"));
        
        
        System.out.println(users);
        
        //sorting using id(asc)
        Collections.sort(users, new IdComparator());
        System.out.println("after sorting" + users);
        
        //now i want to sorting using id but in desc
        Collections.sort(users, new IdComparatorDesc());
        System.out.println("after sorting" + users);
        
        //now want to sort using name(Asc)
        Collections.sort(users, new NameComparator());
        System.out.println("after sorting" + users);
    }
}
 