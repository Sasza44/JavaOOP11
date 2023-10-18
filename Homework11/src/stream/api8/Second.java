package stream.api8;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class Second {

	public static void main(String[] args) {
		File f1 = new File("Fruits2"); // папка з файлами
		File[] arr1 = f1.listFiles();
		Map<String, List<File>> m1 = Arrays.stream(arr1).collect(Collectors.groupingBy(a -> (a.length() < 1024 * 1024) ? "small" : "big")); // розподіл файлів за розміром до та більше 1 МБ
		System.out.println(m1.get("small"));
		System.out.println(m1.get("big"));
	}
}