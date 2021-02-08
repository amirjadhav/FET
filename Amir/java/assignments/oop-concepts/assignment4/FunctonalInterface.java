// Write a program to understand predefined functional interfaces. 
// Implement using anonymous classes 
package assignment4;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctonalInterface {
	public static void main(String[] args) {

		System.out.println(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			};
		}.get());

		new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			};
		}.accept("Hello");

		int num = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t += 1;
			};

		}.apply(10);
		System.out.println(num);

		int num1 = new BiFunction<Integer, Integer, Integer>() {
			public Integer apply(Integer t, Integer u) {
				return t + u;
			};

		}.apply(10, 20);
		System.out.println(num1);

		System.out.println(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 20 ? true : false;
			};
		}.test(2));
	}
}