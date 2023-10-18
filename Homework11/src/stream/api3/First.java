package stream.api3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class First {

	public static void main(String[] args) {
		File f = new File("a1.txt"); // файл з адресами сайтів
		String s1 = readFromFile(f); // читання тексту з файлу
		System.out.println(s1);
		String[] arr1 = s1.split("\n"); // перетворюємо текст на масив рядків
		Stream st1 = Arrays.stream(arr1); // створюємо потік з масиву
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i].substring(0, arr1[i].length() - 1); // видаляємо переноси
		}
		List<String> l1 = (List<String>) st1.filter(a -> !((String) a).contains("ru")).collect(Collectors.toList()); // відкидаємо недоступні адреси за збираємо потік в список
		l1.forEach(e -> System.out.println(e));
	}
	
	public static String readFromFile(File f) { // читання тексту з файлу
		StringBuilder sb = new StringBuilder();
		try (Scanner sc = new Scanner(f)) {
			for(; sc.hasNextLine();) {
				sb.append(sc.nextLine());
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}
}