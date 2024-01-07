package functional;

public class FunDemo implements Account{
	void m() {
		Account.super.pay();
	}
	public static void main(String[] args) {
		
		FunDemo demo = new FunDemo();
		demo.m();
	}
}
