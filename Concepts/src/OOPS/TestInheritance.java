package OOPS;

class Parent {

	public void dispaly() {
		System.out.println("i am parent");
	}
	public void parentDemo() {
		System.out.println("i am parent demo");
	}
}

class Child extends Parent {
	protected void display() {
		System.out.println("i am child");
	}
	public void childDemo() {
		System.out.println("i am child demo");
	}
}

public class TestInheritance {
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.dispaly();
		//parent.childDemo();
		parent.parentDemo();
	}
}
