import domain.Employee;
import domain.StoreEmployee;

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

    System.out.println("\nStore Members:");

    List<StoreEmployee> storeEmployees = new ArrayList<>();
    storeEmployees.add(new StoreEmployee(1505, "June", 2024, "Kisumu"));
    storeEmployees.add(new StoreEmployee(1207, "Nick", 2017, "Langata"));
    storeEmployees.add(new StoreEmployee(1106, "Margaret", 2019, "Langata"));
    storeEmployees.add(new StoreEmployee(1090, "Shadrack", 2021, "Harambee"));
    storeEmployees.add(new StoreEmployee(1305, "Rhoda", 2018, "Kisii"));
    storeEmployees.add(new StoreEmployee(1019, "Zack", 2012, "Langata"));

    var comparator = new StoreEmployee().new StoreComparator<>();
    storeEmployees.sort(comparator);

    for (StoreEmployee e : storeEmployees) {
      System.out.println(e);
    }

    System.out.println("With Pig Latin Name");
    addPigLatinName(storeEmployees);
  }

  public static void addPigLatinName(List<? extends StoreEmployee> list) {

    class DecorativeEmployee extends StoreEmployee implements Comparable<DecorativeEmployee> {
      private String pigLatinName;
      private Employee originalInstance;

      public DecorativeEmployee(String pigLatinName, Employee originalInstance) {
        this.pigLatinName = pigLatinName;
        this.originalInstance = originalInstance;
      }

      @Override
      public String toString() {
        return originalInstance.toString() + " " + pigLatinName;
      }

      @Override
      public int compareTo(DecorativeEmployee decorativeEmployee) {
        return pigLatinName.compareTo(decorativeEmployee.pigLatinName);
      }
    }

    List<DecorativeEmployee> newList = new ArrayList<>(list.size());

    for (var employee : list) {
      String name = employee.getName();
      String pigLatin = name.substring(1) + name.charAt(0) + "ay";
      newList.add(new DecorativeEmployee(pigLatin, employee));
    }

    newList.sort(null);
    
    for (var decEmployee : newList) {
      System.out.println(decEmployee);
    }
  }
}
