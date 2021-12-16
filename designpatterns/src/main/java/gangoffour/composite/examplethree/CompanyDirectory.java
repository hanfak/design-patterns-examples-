package gangoffour.composite.examplethree;

import java.util.ArrayList;
import java.util.List;

public class CompanyDirectory implements Employee {
  private final List<Employee> employeeList = new ArrayList<>();

  @Override
  public void showEmployeeDetails() {
    for (Employee employee : employeeList) {
      employee.showEmployeeDetails();
    }
  }

  public void addEmployee(Employee emp) {
    employeeList.add(emp);
  }

  public void removeEmployee(Employee emp) {
    employeeList.remove(emp);
  }
}