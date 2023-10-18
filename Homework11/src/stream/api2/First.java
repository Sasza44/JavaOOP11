package stream.api2;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.File;

public class First {

	public static void main(String[] args) {
		String s1 = "Down the Rabbit-Hole"; // початковий рядок
		System.out.println(s1);
		String[] arr1 = s1.split(" "); // поділ рядка на масив
		Stream st1 = Arrays.stream(arr1); // створення потоку з масиву
		List<String> l1 = (List<String>) st1.filter(a -> ((String) a).length() <= 5).collect(Collectors.toList()); // фільтрація та збирання в список
		String s2 = String.join(" ", l1); // об'єднання списку в рядок
		System.out.println(s2);
	}
}