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

public class Third {

	public static void main(String[] args) {
		File f1 = new File("Fruits");
		String[] array = f1.list();
		System.out.println(Arrays.toString(array));
		Stream st1 = Arrays.stream(array);
		List<String> l1 = (List<String>) st1.filter(a -> ((String) a).contains(".txt")).collect(Collectors.toList());
		System.out.println(l1);
	}
}