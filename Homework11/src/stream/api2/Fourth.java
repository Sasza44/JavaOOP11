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

public class Fourth {

	public static void main(String[] args) {
		String s1 = "<dependency>\n"
					+ "\t<groupId>junit</groupId>\n"
					+ "\t<artifactId>junit<artifactId>\n"
					+ "\t<version>4.4</version>\n"
					+ "\t<scope>test</scope>\n"
				+ "</dependency>\n"
				+ "<dependency>\n"
					+ "\t<groupId>org.powermock</groupId>\n"
					+ "\t<artifactId>powermock-reflect</artifactId>\n"
					+ "\t<version>3.2</version>\n"
				+ "</dependency>\n";
//		System.out.println(s1);
		String[] arr1 = s1.split("\n"); // поділяємо текст на масив рядків
		Stream s2 = Arrays.stream(arr1); // створюємо потік з останнього масиву
		List<String> l1 = (List<String>) s2.filter(a -> ((String) a).contains("<groupId>")).collect(Collectors.toList()); // виділяємо рядки, які містять тег <groupId>
//		l1.forEach(e -> System.out.println(e));
		List<String> l2 = new ArrayList<>(); // створення нових списків для видалення назви тегу
		List<String> l3 = new ArrayList<>();
		l1.forEach(e -> l2.add(e.replaceAll("\t<groupId>", "")));
		l2.forEach(e -> l3.add(e.replaceAll("</groupId>", "")));
		l3.forEach(e -> System.out.println(e));
	}
}