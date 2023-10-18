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

public class First {

	public static void main(String[] args) {
		String s1 = "Alice and her big sister sat under a tree one sunny day"; // рядок
		String[] arr1 = s1.split(" "); // розбивання рядка на масив по пробілах
		Stream s2 = Arrays.stream(arr1);
		List<String> l1 = (List<String>) s2.filter(a -> getNumbersOfVowelLetters((String) a) != 0) // виключення слів, у яких відсутні голосні букви
		.sorted((a, b) -> getNumbersOfVowelLetters((String) a) - getNumbersOfVowelLetters((String) b)) // сортування слів у порядку зростання кількості голосних букв
		.collect(Collectors.toList());
		System.out.println(l1);
	}
	
	public static int getNumbersOfVowelLetters (String a) { // розрахунок кількості голосних букв в слові
		char[] arr2 = a.toCharArray();
		char[] arr3 = new char[] {'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'};
		int n = 0;
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if(arr2[j] == arr3[i]) { n += 1;}
			}
		}
		return n;
	}
}