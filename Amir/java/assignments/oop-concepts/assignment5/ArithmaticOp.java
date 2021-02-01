
import java.util.function.BiFunction;

public class ArithmaticOp {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (t, u) -> t + u;
        System.out.println(add.apply(10, 20));

        BiFunction<Integer, Integer, Integer> sub = (t, u) -> t - u;
        System.out.println(sub.apply(40, 20));

        BiFunction<Integer, Integer, Integer> mul = (t, u) -> t * u;
        System.out.println(mul.apply(10, 12));

        BiFunction<Integer, Integer, Double> div = (t, u) -> Double.valueOf(t/u);
        System.out.println(div.apply(100, 20));


    }
}