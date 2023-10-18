package stream.api5;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class First {

	public static void main(String[] args) {
		File f1 = new File("a2.txt");
		String s1 = readFromFile(f1); // читання тексту з файлу
		String[] arr1 = s1.split("\n"); // розбиваємо рядок на масив рядків по переносах
		File[] arr2 = new File[arr1.length]; // створюємо масив каталогів
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i].substring(0, arr1[i].length() - 1); // видаляємо переноси у назвах каталогів
			arr2[i] = new File(arr1[i]);
		}
		List<File> l1 = Arrays.stream(arr2).filter(a -> getN(a) > 3).collect(Collectors.toList());
		System.out.println(l1.get(0));
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
	
	public static int getN(File f) { // отримання кількості текстових файлів в каталозі
		String[] arr3 = f.list();
		int n = 0;
		for(int i = 0; i < arr3.length; i++) {
			if(arr3[i].substring(arr3[i].length() - 4, arr3[i].length()).equals(".txt")) {
				n += 1;
			}
		}
		return n;
	}
}