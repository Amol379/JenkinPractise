import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo3 {
	public static void main(String[] args) {

		String str = " hello java world";
		Map<String, Long> collect = Stream.of(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
		
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(10,15,8,49,25,98,98,32,15));
		
		//list.stream().sorted(a->).
		
		List<Integer> integer = list.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
		System.out.println(integer);
		
		 Integer integer1 = list.stream().sorted((a,b)->b.compareTo(a)).distinct().skip(1).findFirst().get();
				System.out.println(integer1);
				
	}
}
