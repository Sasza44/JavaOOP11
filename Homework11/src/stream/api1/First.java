package stream.api1;

import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Optional;

public class First {

	public static void main(String[] args) {
		Cat c1 = new Cat("Luska", 5, "White");
		Cat c2 = new Cat("Umka", 7, "Black");
		Cat c3 = new Cat("Barsic", 2, "Red");
		Cat c4 = new Cat("Luska", 3, "Grey");
		List<Cat> l1 = new ArrayList<>(List.of(c1, c2, c3, c4));
		Stream s1 = l1.stream();
		Optional<Cat> o1 = s1.max((a, b) -> ((Cat) a).getName().length() - ((Cat) b).getName().length());
		System.out.println(o1.get().getName());
	}
}