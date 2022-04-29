package enterprisepatterns.validationengine.version3;

import java.util.Arrays;
import java.util.List;

// List is an input
public class Runner {
  public static void main(String... args) {
    List<String> inputs = Arrays.asList(
        "Hello, my email is bob.duke@google.com",
        "Hello, my number is 3",
        "Hallo, my email is bob.duke@google.com",
        null,
        "Hello, my email is con.duke@google.com"
    );
    // Returns standard exception when at least one validation check fails in one element fails
    StringArgumentValidator stringArgumentValidator = new StringArgumentValidator();
//    System.out.println("validatedInput1 = " );
//    stringArgumentValidator.validate(inputs).forEach(System.out::println);

    // Applies multiple validations to each element, throws exception when at least one element fails a single validation
    StringArgumentValidator1 stringArgumentValidator1 = new StringArgumentValidator1();
    System.out.println("validatedInput2 = " );
    stringArgumentValidator1.validate(inputs).forEach(System.out::println);

  }
}
