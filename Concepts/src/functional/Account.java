package functional;

public interface Account {
	default void pay() {
		System.out.println("i m default interface");
	}
}

