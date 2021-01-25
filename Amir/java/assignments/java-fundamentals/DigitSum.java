import java.util.Scanner;

class Digit {
    int number;

    Digit() {
        number = 0;
    }

    Digit(int number) {
        this.number = number;
    }

    int cal() {
        int sum = 0;
        while (this.number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

public class DigitSum {
    public static void main(String[] args) {
        System.out.println("Enter number between 0 to 1000");
        Scanner sc = new Scanner(System.in);
        System.out.println(new Digit(sc.nextInt()).cal());
        sc.close();
    }
}
