package streams;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StingsProg {

	public static void main(String[] args) {
		String str = "amol is on the way way is going to pune amol is going to pune";
		Map<String, Long> frequencyOfString = Stream.of(str.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequencyOfString);
		System.out.println("****************************************************************");

		String str1 = "Welcome to office Amol";
		long vowelsCount = str1.toLowerCase().chars()
				.filter(ch -> ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u').count();
		System.out.println(vowelsCount);

		Map<Character, Long> vowelsCont = str1.toLowerCase().chars().
				filter(ch -> ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u').
				mapToObj(a->(char)a).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		System.out.println("vowelsCont-->"+vowelsCont);
		
		String str2="a quick brown fox jumps over a lazy dog";
		String s3 = "aeiou";
		/*
		 * for(char c : str2.toCharArray()) { System.out.println(s3.contains((char)c));
		 * }
		 */
		
		  List<Character> vowels=Arrays.asList('a', 'e', 'i', 'o', 'u');
		  Long vowelCount = str2.chars().filter(c -> vowels.contains((char) c)).count();
		  System.out.println(vowelCount);

		  String []s1 = {"amol","kalpak","ankush","monty"};
		  String []s2 = {"amol","kalpak","rahul","ravi"};
		  
		Set<String> hs = new LinkedHashSet<>();
		hs.addAll(Arrays.asList(s1));
		hs.addAll(Arrays.asList(s2));
		hs.stream().forEach(System.out::println);
		 
		 System.out.println("=============");
		  
		/*
		 * List<String[]> asList = Arrays.asList(s1,s2); System.out.println(asList);
		 */
		  Object[] array = Arrays.stream(s1).filter(a->Arrays.stream(s2).allMatch(x->x==a)).toArray();
		  Arrays.stream(array).forEach(System.out::println);
	}
}
