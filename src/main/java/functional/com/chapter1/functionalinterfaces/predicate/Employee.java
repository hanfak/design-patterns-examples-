package functional.com.chapter1.functionalinterfaces.predicate;

import static java.lang.String.format;

public class Employee {

    public Employee(Integer id, Integer age, String gender, String fName, String lName){
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    private final Integer id;
    public final Integer age;
    public final String gender;
    private final String firstName;
    private final String lastName;

    @Override
    public String toString() {
        return format("%s - Age: %s, Gender: %s",firstName.toString(), age.toString(), gender);
    }
}
