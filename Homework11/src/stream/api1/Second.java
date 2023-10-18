package stream.api1;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class Second {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(List.of(16, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1));
		Stream<Integer> s1 = l1.stream().filter(a -> a % 2 != 0).sorted();
		List<Integer> l2 = s1.collect(Collectors.toList());
		System.out.println(l2);
	}
}