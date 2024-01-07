import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
	public static void main(String[] args) {

		File file = new File("F:\\Directory");

		String[] list = file.list();
		/*
		 * for(File s : list) { File[] list2 = s.listFiles();
		 * Arrays.asList(list2).stream().forEach(System.out::println); }
		 */
		Arrays.asList(list).stream().forEach(System.out::println);

		String str = "i love java ";
		Map<Object, Long> collect = Stream.of(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Set<Entry<Object, Long>> collect2 = collect.entrySet().stream().filter(map -> map.getValue() >1)
				.collect(Collectors.toSet());

		System.out.println(collect);
		System.out.println(collect2);
	}
}
