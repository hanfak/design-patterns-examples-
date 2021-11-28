package designpatterns.gangoffour.composite.examplethree;

public class App {
  public static void main(String... args) {
    Developer dev1 = new Developer(100, "Mane", "Pro Developer");
    Developer dev2 = new Developer(101, "Salah", "Developer");

    CompanyDirectory engineersDirectory = new CompanyDirectory();
    engineersDirectory.addEmployee(dev1);
    engineersDirectory.addEmployee(dev2);

    Manager man1 = new Manager(200, "Klopp", "SEO Manager");
    Manager man2 = new Manager(201, "Werner", "Klopp's Manager");

    CompanyDirectory managersDirectory = new CompanyDirectory();
    managersDirectory.addEmployee(man1);
    managersDirectory.addEmployee(man2);

    CompanyDirectory directory = new CompanyDirectory();
    directory.addEmployee(engineersDirectory);
    directory.addEmployee(managersDirectory);
    directory.showEmployeeDetails();
  }
}
