package functional.immutableclass.mutableversion;

// Class can be subclassed and behaviour can be changed
public class MutableClass {
  // Fields not final, so setters can change the state
  public String name;
  public int age;
  public HobbyMutable[] hobbies; // Can change via accessor/getter, as it passes by reference

  public MutableClass(String name, int age, HobbyMutable[] hobbies) {
    this.name = name;
    this.age = age;
    this.hobbies = hobbies;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public HobbyMutable[] getHobbies() {
    return hobbies;
  }

  public void setHobbies(HobbyMutable[] hobbies) {
    this.hobbies = hobbies;
  }
}
