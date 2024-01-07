package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StudentTest {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

		// 1- Find list of students whose first name starts with alphabet A

		List<Student> studentStartWithA = list.stream().filter(stud -> stud.getFirstName().startsWith("A"))
				.collect(Collectors.toList());
		// System.out.println(studentStartWithA);

		// 2- Group The Student By Department Names

		Map<String, List<Student>> grpStudByDept = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName));
		// System.out.println(grpStudByDept);

		// 3- Find the total count of student using stream

		long cntStudent = list.stream().count();
		// System.out.println(cntStudent);

		// 4- Find the max age of student

		Optional<Student> maxAge = list.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
		// System.out.println(maxAge.get().getAge());

		OptionalInt maxAge2 = list.stream().mapToInt(Student::getAge).max();
		// System.out.println(maxAge2.getAsInt());

		// 5- Find all departments names

		List<String> deptName = list.stream().map(Student::getDepartmantName).distinct().collect(Collectors.toList());
		// System.out.println(deptName);

		// 6- Find the count of student in each department

		Map<String, Long> cntStuEachDept = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		// System.out.println(cntStuEachDept);

		// 7- Find the list of students whose age is less than 30
		List<Student> lstStuBelow30 = list.stream().filter(stu -> stu.getAge() < 30).collect(Collectors.toList());
		// System.out.println(lstStuBelow30);

		// 8- Find the list of students whose rank is in between 50 and 100

		List<Student> lstStudRankBet50to100 = list.stream().filter(stu -> stu.getRank() > 50 && stu.getRank() < 100)
				.collect(Collectors.toList());
		// System.out.println(lstStudRankBet50to100);

		// 9- Find the average age of male and female students

		Map<String, Double> avgAge = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));
		// System.out.println(avgAge);

		// 10- Find the department who is having maximum number of students
		Entry<String, Long> deptByMaxStud = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		// System.out.println(deptByMaxStud);

		// 11- Find the Students who stays in Delhi and sort them by their names

		List<Student> stuStayInDelhiWithNameSort = list.stream().filter(stu -> stu.getCity().equalsIgnoreCase("Delhi"))
				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
		// System.out.println(stuStayInDelhiWithNameSort);

		// 12- Find the average rank in all departments

		Map<String, Double> avgRankAllDept = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
		// System.out.println(avgRankAllDept);

		// 13- Find the highest rank in each department

		Map<String, Optional<Student>> hgstRankEachDept = list.stream().collect(Collectors
				.groupingBy(Student::getDepartmantName, Collectors.maxBy(Comparator.comparingInt(Student::getRank))));
		hgstRankEachDept.forEach((k, v) -> System.out.println(k + " " + v.get().getRank()));

		// 14- Find the list of students and sort them by their rank

		List<Student> stuSortByRank = list.stream().sorted(Comparator.comparing(Student::getRank)/* .reversed() */)
				.collect(Collectors.toList());
		// System.out.println(stuSortByRank);

		// 15- Find the student who has second rank

		Student stu2ndRank = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
		System.out.println(stu2ndRank);

	}
}
