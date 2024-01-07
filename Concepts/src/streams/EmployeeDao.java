package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeDao {

	public static List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Amol", "Deshukh", 6900.00, Arrays.asList("project1","project3"), 1000));
		employees.add(new Employee(2, "Aparna", "Deshmukh", 7000.00, Arrays.asList("project1","project2"), 2000));
		employees.add(new Employee(3, "Ravindra", "Rathore", 7500.00, Arrays.asList("project2","project4"), 1000));
		employees.add(new Employee(4, "Monty", "Bharne", 6000.00, Arrays.asList("project3","project2"), 2000));
		employees.add(new Employee(5, "Ankush", "Alode", 5000.00, Arrays.asList("project1","project2"), 3000));
		employees.add(new Employee(6, "Amit", "Kukde", 4500.00, Arrays.asList("project3","project4"), 2000));
		employees.add(new Employee(7, "Rahul", "Dudhankar", 7000.00, Arrays.asList("project1","project3"), 1000));
		employees.add(new Employee(8, "Amol", "Shende", 8000.00, Arrays.asList("project1","project5"), 3000));
		employees.add(new Employee(9, "Nilesh", "Kaned", 5300.00, Arrays.asList("project3","project5"), 3000));
		
		
		return employees;
	}
}
