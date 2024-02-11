package domain;

import java.util.Comparator;

public class StoreEmployee extends Employee {
  private String store;

  public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
    super(employeeId, name, yearStarted);
    this.store = store;
  }

  public StoreEmployee() {
  }

  @Override
  public String toString() {
    return "%-8s%s".formatted(store, super.toString());
  }

  public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {

    @Override
    public int compare(StoreEmployee s1, StoreEmployee s2) {
      int result = s1.store.compareTo(s2.store);

      if (result == 0) {
        return new Employee.EmployeeComparator<>("name").compare(s1, s2);
      }
      return result;
    }
  }
}
