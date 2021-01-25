import java.util.Scanner;

class DigitTest {
    int number;

    DigitTest() {
        number = 0;
    }

    DigitTest(int number) {
        this.number = number;
    }

    void cal() {
        int reverse = 0;
        int rem = 0;
        while (this.number > 0) {
            rem = number % 10;
            reverse = reverse * 10 + rem;
            number /= 10;
        }

        while (reverse > 0) {
            System.out.print(reverse % 10 + " ");
            reverse /= 10;
        }
    }
}

public class DigitSeparate {
    public static void main(String[] args) {
        System.out.println("Enter number between 0 to 1000");
        Scanner sc = new Scanner(System.in);
        new DigitTest(sc.nextInt()).cal();
        System.out.println();
        sc.close();
    }
}
