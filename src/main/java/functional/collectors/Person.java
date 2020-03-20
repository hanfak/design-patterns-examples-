package functional.collectors;

import java.util.StringJoiner;

public class Person {

  private final String name;
  private final int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("age=" + age)
            .toString();
  }
}
