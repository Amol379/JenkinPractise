import java.util.Arrays;
import java.util.List;

public class ThreadDemo {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 3, 4, 6, 7, 8, 9, 2);

		Runnable run1 = () -> {

			for (Integer i : list) {
				if (i % 2 == 0) {
					System.out.println("even values-->" + i + " " + Thread.currentThread().getName());
				}
			}

		};
		Runnable run2 = () -> {

			for (Integer i : list) {
				if (i % 2 != 0) {
					System.out.println("odd values-->" + i + " " + Thread.currentThread().getName());
				}
			}

		};
		Thread thread = new Thread(run1,"EVEN");
		thread.start();
		Thread thread1 = new Thread(run2,"ODD");
		thread1.start();
		System.out.println("hello");
	}
}
