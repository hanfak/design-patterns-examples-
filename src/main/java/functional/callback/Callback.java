package functional.callback;

import java.util.function.Consumer;
import java.util.function.Function;

public class Callback {

  public static void main(String[] args) {

    hello("John", null, value -> {
      System.out.println("no lastName provided for " + value);
    });

    hello2("John",
            null,
            () -> System.out.println("no lastName provided"));

    String output = hello3("John",
            null,
            input -> input + " only has one name");
    System.out.println("output = " + output);

  }

  static void hello(String firstName, String lastName, Consumer<String> callback) {
    System.out.println(firstName);
    if (lastName != null) {
      System.out.println(lastName);
    } else {
      callback.accept(firstName);
    }
  }

  static void hello2(String firstName, String lastName, Runnable callback) {
    System.out.println(firstName);
    if (lastName != null) {
      System.out.println(lastName);
    } else {
      callback.run();
    }
  }

  static String hello3(String firstName, String lastName, Function<String, String> callback) {
    System.out.println(firstName);
    if (lastName != null) {
      return lastName;
    } else {
      return callback.apply(firstName);
    }
  }

//  Example of a callback being used in javascript
//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName)
//        } else {
//            callback();
//        }
//    }
}
