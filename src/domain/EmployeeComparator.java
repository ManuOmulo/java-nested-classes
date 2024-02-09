package domain;

import java.util.Comparator;

public class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
  @Override
  public int compare(Employee e1, Employee e2) {
    return e1.getName().compareTo(e2.getName());
  }
}
