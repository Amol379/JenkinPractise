import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import streams.Employee;

/**
 * @author HP
 *
 */
public class Customer {
	private String name;
	private String phone;
	private String email;
	private String item;
	private int qnty;
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQnty() {
		return qnty;
	}

	public void setQnty(int qnty) {
		this.qnty = qnty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", email=" + email + ", item=" + item + ", qnty=" + qnty
				+ ", price=" + price + "]";
	}

	public Customer(String name, String phone, String email, String item, int qnty, double price) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.item = item;
		this.qnty = qnty;
		this.price = price;
	}

	public static void main(String[] args) {
		List<Customer> listCust = new ArrayList<>();
		listCust.add(new Customer("Abdul", "7760962677", "anmol@gmail.com", "Item1", 5, 500));
		listCust.add(new Customer("Abdul", "7760962677", "anmol@gmail.com", "Item1", 3, 50));
		listCust.add(new Customer("Abdul", "7760962677", "anmol@gmail.com", "Item1", 1, 1567));
		listCust.add(new Customer("Sangeetha", "7760962678", "sam@gmail.com", "Item1", 5, 500));
		listCust.add(new Customer("Sangeetha", "7760962678", "sam@gmail.com", "Item1", 3, 50));
		listCust.add(new Customer("Sangeetha", "7760962678", "sam@gmail.com", "Item1", 1, 1567));
		listCust.add(new Customer("Amul", "7760962679", "", "Item1", 5, 500));
		listCust.add(new Customer("Amul", "7760962679", "", "Item1", 3, 50));
		listCust.add(new Customer("Amul", "7760962679", "", "Item1", 1, 1567));
		listCust.add(new Customer("Sangeetha", "", "sam1m@gmail.com", "Item1", 5, 500));
		listCust.add(new Customer("Sangeetha", "", "sam1m@gmail.com", "Item1", 3, 50));
		listCust.add(new Customer("Sangeetha", "", "sam1m@gmail.com", "Item1", 1, 1567));
		listCust.add(new Customer("Abdul", "8760962678", "anmol@gmail.com", "Item1", 5, 500));
		listCust.add(new Customer("Abdul", "8760962678", "anmol@gmail.com", "Item1", 3, 50));
		listCust.add(new Customer("Abdul", "8760962678", "anmol@gmail.com", "Item2", 1, 1567));

		Set<Customer> set = new TreeSet<>(Comparator.comparing(Customer::getItem));
		set.addAll( listCust);
		System.out.println(set);
		
		// Function<Customer, Object> candiadte = c ->
		// Arrays.asList(c.getPhone(),c.getEmail());

		//listCust.stream().map(c -> c.getPrice() + "").filter(q -> q.startsWith("1")).forEach(System.out::println);

		Map<Object, Long> collect = listCust.stream()
				// .filter(c -> c.getEmail().isEmpty() || c.getPhone().isEmpty())
				.collect(Collectors.groupingBy(c -> Arrays.asList(c.getPhone(), c.getEmail()), Collectors.counting()));
		System.out.println(collect);
	}
}
