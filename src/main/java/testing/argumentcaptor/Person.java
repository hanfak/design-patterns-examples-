package testing.argumentcaptor;

import com.google.common.base.Objects;

public class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equal(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
