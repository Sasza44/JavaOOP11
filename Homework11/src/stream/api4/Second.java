package stream.api4;

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
		Student student1 = new Student("Tipikin", "Oleksandr", 20);
		Student student2 = new Student("Sutula", "Sergey", 19);
		Student student3 = new Student("Topchiy", "Yulia", 18);
		Student student4 = new Student("Shakura", "Oleg", 21);
		Student student5 = new Student("Melnikov", "Yevgen", 20);
		List<Student> l1 = new ArrayList<>(List.of(student1, student2, student3, student4, student5));
		List<Student> l2 = l1.stream().filter(a -> a.getAge() >= 20).sorted((a, b) -> a.getLastName().compareTo(b.getLastName())).collect(Collectors.toList());
		l2.forEach(e -> System.out.println(e.getLastName() + " " + e.getFirstName()));
	}
}