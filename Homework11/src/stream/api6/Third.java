package stream.api6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Third {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(List.of(2, 46, 586));
		Optional<Integer> op1 = l1.stream().reduce((a, b) -> (a > b) ? a : b);
		System.out.println(op1.get());
	}
}