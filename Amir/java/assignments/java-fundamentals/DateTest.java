class Date {

    int day;
    int month;
    int year;

    public Date() {
        day = 1;
        month = 1;
        year = 1970;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
    }

}

public class DateTest {
    public static void main(String[] args) {
        System.out.println("Date Example");

        Date o1 = new Date();
        Date o2 = new Date(12, 01, 1996);

        System.out.println(o1);
        System.out.println(o2);
    }
}
