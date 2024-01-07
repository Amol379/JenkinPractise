package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreams {
	public static void main(String[] args) {
		long count = EmployeeDao.getEmployees().stream().count();
		System.out.println(count);
		System.out.println("*****************************************************************");
		// find employee whose salary more than 5k
		List<Employee> findSalgtfive = EmployeeDao.getEmployees().stream().filter(e -> e.getSalary() > 5000)
				.collect(Collectors.toList());
		System.out.println(findSalgtfive);
		System.out.println("*****************************************************************");
		// find employee whose sal is max by dept

		Map<Integer, Employee> maxSalByDept = EmployeeDao.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), e -> e.get())));
		maxSalByDept.entrySet().forEach(System.out::println);
		System.out.println("****hello*************************************************************");
		/*
		 * EmployeeDao.getEmployees().stream()
		 * .collect(Collectors.groupingBy(Employee::getDeptId,
		 * Collectors.collectingAndThen(
		 * Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), emp ->
		 * emp.get()))) .entrySet().forEach(System.out::println);
		 */

		// averaging the salary to individual department

		EmployeeDao.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().forEach(System.out::println);
		System.out.println("*****************************************************************");
		// find employee whose name startwith 'a'

		EmployeeDao.getEmployees().stream().filter(emp -> emp.getName().startsWith("A")).forEach(System.out::println);
		System.out.println("*****************************************************************");
		// sort the employee with name and lastname

		EmployeeDao.getEmployees().stream()
				.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getLastName))
				.forEach(System.out::println);
		// .collect(Collectors.toList());
		// System.out.println(sortEmpByNameAndLastName);
		System.out.println("*****************************************************************");
		// find highest paid employee
		Employee maxSalEmp = EmployeeDao.getEmployees().stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(maxSalEmp);
		System.out.println("***************00**************************************************");
		// increase the salary by 10% for depatmet 1000
		List<Employee> empByDept = EmployeeDao.getEmployees().stream().map(emp -> {
			if (emp.getDeptId() == 1000) {
				emp.setSalary(emp.getSalary() * 1.25);
			}
			return emp;
		}).collect(Collectors.toList());
		System.out.println(empByDept);
		System.out.println("************11*****************************************************");
		EmployeeDao.getEmployees().stream().filter(e -> e.getDeptId() == 1000).map(e -> {
			e.setSalary(e.getSalary() * 1.20);
			return e;
		}).forEach(System.out::println);

		System.out.println("*****************************************************************");

		EmployeeDao.getEmployees().stream().filter(e -> e.getDeptId() == 1000).map(e -> e.getSalary() * 1.20)
				.forEach(System.out::println);
		System.out.println("*****************************************************************");
		
		Map<Integer, List<Employee>> collect = EmployeeDao.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toList()));
		System.out.println(collect);
	}
}
