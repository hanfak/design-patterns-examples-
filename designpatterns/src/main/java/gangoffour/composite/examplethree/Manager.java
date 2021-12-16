package gangoffour.composite.examplethree;

public class Manager implements Employee {
  private final String name;
  private final long empId;
  private final String position;

  public Manager(long empId, String name, String position) {
    this.empId = empId;
    this.name = name;
    this.position = position;
  }

  @Override
  public void showEmployeeDetails() {
    System.out.println("Management");
    System.out.println(empId + " " + name + " : " + position);
  }
}
