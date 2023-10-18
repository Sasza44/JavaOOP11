package stream.api7;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class First {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(List.of(54, 2, 546, 34, 965, 4, 2));
		System.out.println(l1);
		Stream st1 = l1.stream();
		Set<Integer> s1 = (Set<Integer>) st1.collect(Collectors.toSet()); // набір, отриманий методом Collectors.toSet()
		System.out.println(s1);
		
		Collector<Integer, Set<Integer>, Set<Integer>> c1 = new CreateSet();
		Stream st2 = l1.stream();
		HashSet s2 = (HashSet) st2.collect(c1); // набір, отриманий реалізацією інтерфейсу Collector;
		System.out.println(s2);
	}
}

class CreateSet implements Collector<Integer, Set<Integer>, Set<Integer>> {

	@Override
	public Supplier<Set<Integer>> supplier() {
		return HashSet::new;
	}
	@Override
	public BiConsumer<Set<Integer>, Integer> accumulator() {
		return (a, b) -> a.add(b);
	}
	@Override
	public BinaryOperator<Set<Integer>> combiner() {
		return (a, b) -> {
			HashSet<Integer> hs = new HashSet<>();
			hs.addAll(a);
			hs.addAll(b);
			return hs;
		};
	}
	@Override
	public Function<Set<Integer>, Set<Integer>> finisher() {
		return (a) -> {
			HashSet<Integer> hs = new HashSet<>();
			hs.addAll(a);
			return hs;
		};
	}
	@Override
	public Set<Characteristics> characteristics() {
		return Set.of();
	}
}