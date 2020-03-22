package functional.immutableclass.immutableversion;

public final class ImutableClass {
  private final String name;
  private final int age;
  private final  HobbyImutable[] hobbies;

  public ImutableClass(String name, int age, HobbyImutable[] hobbies) {
    this.name = name;
    this.age = age;
    this.hobbies = hobbies;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public HobbyImutable[] getHobbies() {
    return hobbies;
  }
}
