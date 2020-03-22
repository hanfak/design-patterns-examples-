package functional.immutableclass.mutableversion;

public class Runner {
  public static void main(String... args) {
    HobbyMutable[] hobbies = new HobbyMutable[10];
    hobbies[0] = new HobbyMutable("sport", 50L);
    MutableClass han = new MutableClass("Han", 21, hobbies);

    HobbyMutable[] hobbies1 = han.getHobbies();
    hobbies1[1] = new HobbyMutable("cars", 5000L);
    System.out.println("Added hobbies");
    System.out.println("hobbies1 = " + hobbies1[0]);
    System.out.println("hobbies1 = " + hobbies1[1]);

    hobbies1[0] = new HobbyMutable("sport", 5110L);

    System.out.println("altered hobbies outside of the class = " + hobbies1[0] + "\n" + hobbies1[1]);
  }
}
