package stream.api4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Third {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(List.of(374, 40, 5, 8, 294, 76, 3, 59));
		List<Integer> l2 = l1.stream().filter(a -> a > 10).sorted((a, b) -> getLastNumber(a) - getLastNumber(b)).collect(Collectors.toList());
		System.out.println(l1);
		System.out.println(l2);
	}
	
	public static int getLastNumber(int n) { // отримання останньої цифри цілого числа
		String s = String.valueOf(n);
		String s2 = s.substring(s.length() - 1, s.length());
		return Integer.parseInt(s2);
	}
}