package functional.com.chapter1.functionalinterfaces.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates
{
    public static Predicate<Employee> isAdultMale() {
        return p -> p.age > 21 && p.gender.equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale() {
        return p -> p.age > 21 && p.gender.equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isFemale() {
        return p -> p.gender.equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeLessThan(int age) {
        return p -> p.age < age;
    }

    public static List<Employee> filterEmployees (List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter( predicate ).collect(Collectors.<Employee>toList());
    }
}
