package stream.api6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class First {

	public static void main(String[] args) {
		String s1 = "Alice and her big sister sat under a tree one sunny day";
		String[] array1 = s1.split(" "); // розбиваємо рядок на масив (по пробілах)
		int[] array2 = new int[array1.length]; // створюємо відповідний числовий масив (по кількості літер в слові)
		for(int i = 0; i < array1.length; i++) {
			array2[i] = array1[i].length();
		}
		OptionalInt o1 = Arrays.stream(array2).filter(a -> a > 4).reduce((a, b) -> a + b);
		System.out.println(o1.getAsInt());
	}
}