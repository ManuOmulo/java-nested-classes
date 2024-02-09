import domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1001, "James", 2015));
    employees.add(new Employee(1204, "Emmanuel", 2023));
    employees.add(new Employee(1105, "Philip", 2021));
    employees.add(new Employee(1019, "Jordan", 2012));

    employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }
}
