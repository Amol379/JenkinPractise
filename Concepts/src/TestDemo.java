import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Mapper {

	public static Function<String, CharactersCount> getDistinctCharactersCount() {

		return s -> new CharactersCount(s, (int) s.chars().distinct().count());

	}

}

class CharactersCount {

	private final String name;

	private final Integer distinctCharacterCount;

	public CharactersCount(String name, Integer distinctCharacterCount) {

		this.name = name;

		this.distinctCharacterCount = distinctCharacterCount;

	}

	@Override

	public String toString() {

		return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";

	}
}

public class TestDemo {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah",
				"allessandra", "allianna", "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle",
				"annebelle"

		);

		strList.stream().filter(e -> e.startsWith("aa")).map(Mapper.getDistinctCharactersCount())
				.forEachOrdered(System.out::println);

		List<String> listStrtWithAA = strList.stream().filter(e -> e.startsWith("aa")).
		// collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
				collect(Collectors.toList());
		System.out.println("hello-->" + listStrtWithAA);

		// listStrtWithAA.stream()

		/*
		 * Map<String[], Long> collect =
		 * listWStrtWithAA.stream().map(e->e.split("")).distinct()//flatMap(w->Arrays.
		 * stream(w)) .collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting()));
		 * collect.entrySet().stream().forEach(e->System.out.println(collect.get(e)));
		 */
		/*
		 * Sample Output aaryanna - 4 aayanna - 3 Explaination:- aaryanna has four
		 * distinct characters: 'a', 'n', 'r', and 'y'. aayanna has three distinct
		 * characters: 'a', 'n', and 'y'.
		 */

		Map<String, Integer> map = new HashMap<>();
		map.put("x", 100);
		map.put("n", 500);
		map.put("z", 50);
		map.put("i", 300);
		List<Entry<String, Integer>> collect = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
				.collect(Collectors.toList());
		System.out.println("hel===>" + collect);
		Entry<String, Integer> entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(entry);

		String str1 = "amol";
		String revStr1 = Stream.of(str1).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining());
		System.out.println("new way--> " + revStr1);
		String revStr = Arrays.stream(str1.split("")).sorted((s1, s2) -> -1).collect(Collectors.joining());
		System.out.println(revStr);

		Arrays.asList(str1.split("")).stream().collect(Collectors.groupingBy(a -> a, Collectors.counting())).entrySet()
				.forEach(System.out::println);

		String str2 = "abc dea ade";
		String rev = Stream.of(str2).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining());
		System.out.println("map2-->" + rev);
		// Set<String> set = new HashSet();

		// Set<String> un = Stream.of(str2.split("")).filter(e->Collections.frequency(,
		// e)>1)
		// .collect(Collectors.toSet());
		Map<String, Long> calval = Stream.of(str2.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(calval);

		Set<String> dup = calval.entrySet().stream().filter(m -> m.getValue() > 1).map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		System.out.println(dup);
	}
}
