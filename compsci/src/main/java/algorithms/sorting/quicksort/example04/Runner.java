package algorithms.sorting.quicksort.example04;

import static algorithms.sorting.Util.*;
import static algorithms.sorting.Util.printArray;

public class Runner {

    public static void main(String... args) {
        Employee[] employees = new Employee[5];
        Employee employee = new Employee("John","Carter",5658);
        employees[0] = employee;
        employee = new Employee("Mary","Carter",7412);
        employees[1] = employee;
        employee = new Employee("Alex","Lumb",1358);
        employees[2] = employee;
        employee = new Employee("David","Jhonson",1254);
        employees[3] = employee;
        employee = new Employee("Shaun","Smith",4587);
        employees[4] = employee;

        System.out.println("Before:");
        printArray(employees);

        QuickSort<Employee> quickSort = new QuickSort<>();
        Runnable runnable = () -> quickSort.apply(employees);
        measureTimeOfExecution(runnable);

        System.out.println("after:");
        printArray(employees);
    }
    public static void printArray(Employee[] numbers) {
        for (Employee number : numbers) {
            System.out.println(number);
        }
    }
}
