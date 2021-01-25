
import java.util.Scanner;

// Write a Java program to insert an element (specific position) into an array.

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position:");
        int pos = sc.nextInt();

        System.out.println("Enter number:");
        int number = sc.nextInt();

        arr[pos - 1] = number;
        for (int i : arr) {
            System.out.println(i);
        }
        sc.close();
    }
}
