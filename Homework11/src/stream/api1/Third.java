package stream.api1;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.File;

public class Third {

	public static void main(String[] args) {
		File fruits = new File("Fruits"); // каталог з файлами
		File[] array = fruits.listFiles(); // масив з файлів
		Stream<File> s1 = Arrays.stream(array);
		Optional<File> f = s1.max((a, b) -> (int)a.length() - (int)b.length());
		System.out.println(f.get());
	}
}