package gangoffour.prototype.examplethree;

import java.util.ArrayList;
import java.util.List;

public class Employees  implements Cloneable {
  private final List<String> empList;

  public Employees() {
    empList = new ArrayList<>();
  }

  public Employees(List<String> list) {
    this.empList = list;
  }

  public void loadData() {
    // read all employees from database and put into the list
    empList.add("Roshan");
    empList.add("Akhil");
    empList.add("Binu");
    empList.add("Shiji");
  }

  public List<String> getEmpList() {
    return empList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> temp = new ArrayList<>();
    for (String s : this.getEmpList()) {
      temp.add(s);
    }
//    List<String> temp = Collections.unmodifiableList(this.getEmpList());
    return new Employees(temp);
  }
}