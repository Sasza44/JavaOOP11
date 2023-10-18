package stream.api5;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Second {

	public static void main(String[] args) {
		ProgrammingLanguage p1 = new ProgrammingLanguage("Haskell", DifficultyLevel.HARD);
		ProgrammingLanguage p2 = new ProgrammingLanguage("Python", DifficultyLevel.EASY);
		ProgrammingLanguage p3 = new ProgrammingLanguage("Java", DifficultyLevel.MEDIUM);
		ProgrammingLanguage p4 = new ProgrammingLanguage("C++", DifficultyLevel.HARD);
		ProgrammingLanguage p5 = new ProgrammingLanguage("JS", DifficultyLevel.EASY);
		List<ProgrammingLanguage> l1 = new ArrayList<>(List.of(p1, p2, p3, p4, p5));
		List<ProgrammingLanguage> l2 = l1.stream().filter(a -> a.getComplexity() == DifficultyLevel.MEDIUM).collect(Collectors.toList()); // обираємо середній рівень складності
		l2.forEach(a -> System.out.println(a));
	}
	
	public static int compareHard(ProgrammingLanguage a, ProgrammingLanguage b) {
		if(a.getComplexity().ordinal() > b.getComplexity().ordinal()) {return 1;}
		if(a.getComplexity().ordinal() < b.getComplexity().ordinal()) {return -1;}
		return Integer.compare(a.getName().length(), b.getName().length());
	}
}

enum DifficultyLevel {
	EASY, MEDIUM, HARD;
}

class ProgrammingLanguage {
	private String name;
	private DifficultyLevel complexity;
	
	public ProgrammingLanguage(String name, DifficultyLevel complexity) {
		super();
		this.name = name;
		this.complexity = complexity;
	}
	public String getName() {
		return name;
	}
	public DifficultyLevel getComplexity() {
		return complexity;
	}
	@Override
	public String toString() {
		return "ProgrammingLanguage [name=" + name + ", complexity=" + complexity + "]";
	}
}