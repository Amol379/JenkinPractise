package MultiThread;

public class EvenAndOddPrintBy2Thread implements Runnable {

	Object object;

	public EvenAndOddPrintBy2Thread(Object object) {
		this.object = object;
	}

	static int count = 10;

	@Override
	public void run() {
		while (count >= 1
				) {
			if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
				synchronized (object) {
					System.out.println("Thread Name :" + Thread.currentThread().getName() + " value :" + count);
					count--;
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
				synchronized (object) {
					System.out.println("Thread Name :" + Thread.currentThread().getName() + " value :" + count);
					object.notify();
					count--;
				}
			}
		}
	}

	public static void main(String[] args) {
		Object obj = new Object();
		Runnable r1 = new EvenAndOddPrintBy2Thread(obj);
		Runnable r2 = new EvenAndOddPrintBy2Thread(obj);

		new Thread(r1, "even").start();
		new Thread(r2, "odd").start();

	}

}
