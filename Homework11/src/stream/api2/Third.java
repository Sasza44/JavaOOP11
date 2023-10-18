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

public class Third {

	public static void main(String[] args) {
		Cat c1 = new Cat("Luska", 5, "White");
		Cat c2 = new Cat("Umka", 7, "Black");
		Cat c3 = new Cat("Barsic", 2, "Red");
		Cat c4 = new Cat("Kuzia", 3, "Grey");
		List<Cat> cats = new ArrayList<>(List.of(c1, c2, c3, c4));
		Stream s1 = cats.stream();
		List<Cat> cats1 = (List<Cat>) s1.filter(a -> ((Cat) a).getWeight() >= 3).sorted((a, b) -> ((Cat) a).getName().compareTo(((Cat) b).getName())).collect(Collectors.toList());
		cats1.forEach(e -> System.out.println(e));
	}
}