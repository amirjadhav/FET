// Write a Java program to get the last date of the month also get current full date and time.(use
// java 8 date time api)

import java.util.Calendar;

class DateApiTest {

    DateApiTest() {
        Calendar cal = Calendar.getInstance();
        int res = cal.getActualMaximum(Calendar.DATE);
        System.out.println("Last Date of the current month = " + res);
        System.out.println("Current date is:" + cal.getTime());
    }
}

public class DateApi {
    public static void main(String[] args) {
        System.out.println("Hello");
        new DateApiTest();
    }
}