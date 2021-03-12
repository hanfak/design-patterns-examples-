package filesapi.domain;

public class Person {
    public String name;
    public Integer age;
    public Boolean male;

    public Person(String name, Integer age, Boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public Person() {
    }
}
