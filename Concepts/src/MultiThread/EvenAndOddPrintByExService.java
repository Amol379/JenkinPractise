package MultiThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenAndOddPrintByExService {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		IntStream.rangeClosed(1, 10).forEach(num -> {
			CompletableFuture<Integer> oddCompletebleFuture = CompletableFuture.completedFuture(num)
					.thenApplyAsync(x -> {
						if (x % 2 != 0) {
							System.out.println("Thred Name: " + Thread.currentThread().getName() + " value" + x);
						}
						return num;
					}, service);
			oddCompletebleFuture.join();
			CompletableFuture<Integer> evenCompletebleFuture = CompletableFuture.completedFuture(num)
					.thenApplyAsync(x -> {
						if (x % 2 == 0) {
							System.out.println("Thred Name: " + Thread.currentThread().getName() + " value" + x);
						}
						return num;
					}, service);
			evenCompletebleFuture.join();
		});
		service.shutdown();
	}
}
