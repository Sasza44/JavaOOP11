package stream.api8;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class First {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(List.of(54, 2, 546, 34, 965, 4, 45, 93)); // список цілих чисел
		System.out.println(l1);
		Map<Object, List<Integer>> map = l1.stream().collect(Collectors.groupingBy(a -> (a % 2 == 0) ? "even" : "odd")); // розподіл на непарні та парні
		System.out.println(map.get("odd"));
		System.out.println(map.get("even"));
		String s1 = map.get("odd").stream().map(a -> String.valueOf(a)).collect(Collectors.joining(";")); // перетворення списку непарних чисел на список рядків з об'єднанням
		String s2 = map.get("even").stream().map(a -> String.valueOf(a)).collect(Collectors.joining(";")); // те саме для парних
		System.out.println(s1); // непарні числа
		System.out.println(s2); // парні числа
	}
}