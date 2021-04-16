package enterprisepatterns.validationengine.version1;

public class Runner {
  public static void main(String... args) {
    // Returns standard exception when at least one validation check fails
    StringArgumentValidator stringArgumentValidator = new StringArgumentValidator();
    String validatedInput1 = stringArgumentValidator.validate("Hello, my email is bob.duke@google.com");
    System.out.println("validatedInput1 = " + validatedInput1);

    // The following inputs will fail
//    // Throw exception
//    String validatedInput2 = stringArgumentValidator.validateBookReference("Hallo, my email is bob.duke@google.com");
//    System.out.println("validatedInput2 = " + validatedInput2);
//     Throw exception
//    String validatedInput3 = stringArgumentValidator.validateBookReference("");
//    System.out.println("validatedInput3 = " + validatedInput3);
//    // Throw exception
//    String validatedInput4 = stringArgumentValidator.validateBookReference(null);
//    System.out.println("validatedInput4 = " + validatedInput4);

    // This will fail on the second email not being correct, but passes the Hello check is correct
//    String validatedInput5 = stringArgumentValidator.validateBookReference("Hello, my email is bob.duke;google.com");
//    System.out.println("validatedInput5 = " + validatedInput5);
  }
}
