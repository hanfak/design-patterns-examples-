package functional.com.chapter1.functionalinterfaces.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static functional.com.chapter1.functionalinterfaces.predicate.EmployeePredicates.*;
import static java.lang.String.format;

/**
 * Use of predicate functional interface
 *
 *
 *
**/
public class TestEmployeePredicates {
    public static void main(String[] args){
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,23,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,35,"M","Naveen","Jain");

        List<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10));

        System.out.println("Employes who are male and over 21:");
        System.out.println(filterEmployees(employees, isAdultMale()));

        System.out.println("Employes who are female and over 21:");
        System.out.println(filterEmployees(employees, isAdultFemale()));

        System.out.println("\nEmployes less than 35:");
        List<Employee> employeesUnder35 = filterEmployees(employees, isAgeLessThan(35));
        System.out.println(employeesUnder35);
        System.out.println("Of those employers who are female");
        // instead of calling filterEmployees(employeesUnder35, isFemale())
        employeesUnder35.stream().filter(isFemale())
                .forEach(System.out::println);
        // When in List form, toString() prints out pretty format of array
//        System.out.println(employeesUnder35.stream().filter(isFemale()).collect(Collectors.toList()));
        System.out.println("Alternate way");
        employeesUnder35.stream()
                .filter(employee -> employee.gender.equals("F"))
                .forEach(System.out::println);

        System.out.println("\nEmployes who are male or female and over 21:");
        System.out.println(filterEmployees(employees, isAdultMale().or(isAdultFemale())));

        System.out.println("\nEmployes who are under 35 and 21 and over:");
        System.out.println(filterEmployees(employees, isAgeLessThan(35).and(isAgeLessThan(21).negate())));

        System.out.println(format("\nEmployees older or equal to 35 %s", filterEmployees(employees, isAgeLessThan(35).negate())));
    }
}

