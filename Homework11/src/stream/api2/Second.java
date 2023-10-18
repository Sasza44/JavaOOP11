package stream.api2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Second {

	public static void main(String[] args) {
		String s1 = "Моя батьківщина Ukraine"; // рядок
		char[] arr1 = s1.toCharArray(); // перетворення рядка на масив символів
		List<Integer> l1 = new ArrayList<>(); // перетворення масиву символів на список їхніх кодів
		for(int i = 0; i < arr1.length; i++) {
			l1.add((int) arr1[i]);
		}
		Stream s2 = l1.stream();
		List<Integer> l2 = (List<Integer>) s2.filter(a -> (int)a > 64 && (int)a < 123).collect(Collectors.toList()); // залишаємо лише коди англійських літер
		char[] arr2 = new char[l2.size()]; // перетворюємо список кодів на масив символів
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = (char) (int)l2.get(i);
		}
		String s3 = new String(arr2); // об'єднуємо масив символів в рядок
		System.out.println(s3);
	}
}