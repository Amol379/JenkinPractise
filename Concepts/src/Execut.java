import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Execut {

	public static void display() {
		System.out.println("i am print " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			service.execute(() -> {
				display();
			});
		}
		service.shutdown();
		/*
		 * Runnable r = () -> { for (int i = 0; i < 10; i++) {
		 * 
		 * display(); } }; service.submit(r);
		 */
	}
}
