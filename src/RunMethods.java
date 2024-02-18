import domain.Employee;
import domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
  public static void main(String[] args) {
    List<StoreEmployee> storeEmployees = new ArrayList<>();
    storeEmployees.add(new StoreEmployee(1505, "June", 2024, "Kisumu"));
    storeEmployees.add(new StoreEmployee(1207, "Nick", 2017, "Langata"));
    storeEmployees.add(new StoreEmployee(1106, "Margaret", 2019, "Langata"));
    storeEmployees.add(new StoreEmployee(1090, "Shadrack", 2021, "Harambee"));
    storeEmployees.add(new StoreEmployee(1305, "Rhoda", 2018, "Kisii"));
    storeEmployees.add(new StoreEmployee(1019, "Zack", 2012, "Langata"));

    var c0 = new Employee.EmployeeComparator<StoreEmployee>();
    var c1 = new StoreEmployee().new StoreComparator<StoreEmployee>();

//  Using Anonymous class
    var c3 = new Comparator<StoreEmployee>(){
      @Override
      public int compare(StoreEmployee e1, StoreEmployee e2) {
        return e1.getName().compareTo(e2.getName());
      }
    };

    sortIt(storeEmployees, c0);
    sortIt(storeEmployees, c1);
    sortIt(storeEmployees, c3);
  }

  public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
    System.out.println("Sorting with comparator " + comparator.toString());

    list.sort(comparator);

    for (var employee: list) {
      System.out.println(employee);
    }
  }
}
