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

public class Second {

	public static void main(String[] args) {
		Singer singer1 = new Singer("Freddie Mercury", new String[] {"We are the champions", "Somebody to Love"});
		Singer singer2 = new Singer("David Bowie", new String[] {"Space Oddity", "Let Me Sleep Beside You", "Suffragette City"});
		Singer singer3 = new Singer("James Paul McCartney", new String[] {"Can’t Buy Me Love", "Another Girl"});
		Singer[] rockStars = new Singer[] { singer1, singer2, singer3 };
		Stream s1 = Arrays.stream(rockStars);
		List<String> l1 = (List<String>) s1.flatMap(n -> Arrays.stream(((Singer) n).getSongs())).sorted((a, b) -> ((String) a).compareTo((String) b)).limit(3).collect(Collectors.toList());
		System.out.println(l1);
	}
}