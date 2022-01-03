package algorithms.sorting.quicksort.example04;

public class Employee implements Comparable<Employee> {

    private String firstName;
    private String lastName;
    private int emplyeeCode;

    public Employee(String fistName, String lastName, int emplyeeCode) {
        this.firstName = fistName;
        this.lastName = lastName;
        this.emplyeeCode = emplyeeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmplyeeCode() {
        return emplyeeCode;
    }

    public String toString() {
        return "Employee Code: " + getEmplyeeCode() + ", Name:" + getFirstName() + " " + getLastName();
    }

    public int compareTo(Employee o) {
        // or
         return Integer.compare(this.emplyeeCode, o.getEmplyeeCode());
//        if (this.emplyeeCode > o.getEmplyeeCode()) {
//            return 1;
//        }
//        if (this.emplyeeCode < o.getEmplyeeCode()) {
//            return -1;
//        }
//        return 0;
    }
}
