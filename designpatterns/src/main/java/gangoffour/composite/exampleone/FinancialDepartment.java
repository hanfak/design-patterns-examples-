package gangoffour.composite.exampleone;

public class FinancialDepartment implements Department {

  private final Integer id;
  private final String name;

  public FinancialDepartment(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public void printDepartmentName() {
    System.out.println(getClass().getSimpleName());
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
