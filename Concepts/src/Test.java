import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {

		/*
		 * List<Integer> asList = Arrays.asList(2,5,6,7,2,1,6,9);
		 * asList.stream().sorted(Collections.reverseOrder()).forEach(System.out::
		 * println);
		 */

		int[] arr = { 2, 6, 2, 7, 8, 9 };

		List<Integer> collect = IntStream.of(arr).boxed().sorted((a, b) ->-1).collect(Collectors.toList());
		System.out.println("c-->"+collect);
		Stream.of(arr).sorted((a, c) -> -1).collect(Collectors.toList());

		// System.out.println(()->In);
		int n = arr.length;
		System.out.println("n-->"+n);
		int[] temp = new int[arr.length];
		System.out.println(Arrays.toString(arr));
		for (int i = n - 1; i > 0; i--) {
			
			temp[n - i - 1] = arr[i];

		}
		System.out.println(Arrays.toString(temp));
		System.out.println("pos 2-> " + temp[1]);

	}

}
