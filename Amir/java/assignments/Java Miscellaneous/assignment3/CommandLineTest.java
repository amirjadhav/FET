import java.util.Arrays;

public class CommandLineTest {
    public static void main(String[] args) {
        int i = 0;
        int[] numbers = new int[args.length];
        for (String str : args) {
            numbers[i++] = Integer.parseInt(str);
        }
        Arrays.sort(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
