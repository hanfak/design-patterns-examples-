package gangoffour.composite.exampleone;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {

  private final Integer id;
  private final String name;

  private final List<Department> childDepartments;

  public HeadDepartment(Integer id, String name) {
    this.id = id;
    this.name = name;
    this.childDepartments = new ArrayList<>();
  }

  public void printDepartmentName() {
    childDepartments.forEach(Department::printDepartmentName);
  }

  public void addDepartMent(Department department) {
    childDepartments.add(department);
  }

  public void removeDepartment(Department department) {
    childDepartments.remove(department);
  }
}
