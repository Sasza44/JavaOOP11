package stream.api7;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Stream;

public class Second {

	public static void main(String[] args) {
		String s1 = "bbbb Down the Rabbit-hole";
		String[] arr1 = s1.split(" ");
		Predicate<String> pr1 = a -> checkVowelLetter(a) == true;
		Collector<String, TreeMap<Integer, String>, TreeMap<Integer, String>> c1 = new CreateMap(pr1);
		Stream st1 = Arrays.stream(arr1);
		TreeMap m1 = (TreeMap) st1.collect(c1);
		List<Integer> l1 = new ArrayList<>(m1.keySet()); // список ключів
		List<String> l2 = new ArrayList<>(m1.values()); // список значень
		System.out.println(l2);
	}
	public static boolean checkVowelLetter(String s) { // перевірка, чи має слово голосні букви
		char[] arr = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};
		boolean b = false;
		for(int i = 0; i < arr.length; i++) {
			if(s.indexOf(arr[i]) != -1) {b = true;}
		}
		return b;
	}
}

class CreateMap implements Collector<String, TreeMap<Integer, String>, TreeMap<Integer, String>> {
	private Predicate<String> pr1;
	public CreateMap(Predicate<String> pr1) {
		super();
		this.pr1 = pr1;
	}
	@Override
	public Supplier<TreeMap<Integer, String>> supplier() {
		return TreeMap::new;
	}
	@Override
	public BiConsumer<TreeMap<Integer, String>, String> accumulator() {
		return (a, b) -> {
			if(pr1.test(b)) {
				int n = a.size() + 1; // ключ - ціле число, починаючи від 1
				a.put(n, b);
			}
		};
	}
	@Override
	public BinaryOperator<TreeMap<Integer, String>> combiner() {
		return (a, b) -> {
			TreeMap<Integer, String> m = new TreeMap<>();
			m.putAll(a);
			m.putAll(b);
			return m;
		};
	}
	@Override
	public Function<TreeMap<Integer, String>, TreeMap<Integer, String>> finisher() {
		return (a) -> {
			TreeMap<Integer, String> m = new TreeMap<>();
			m.putAll(a);
			return m;
		};
	}
	@Override
	public Set<Characteristics> characteristics() {
		return Set.of();
	}
}