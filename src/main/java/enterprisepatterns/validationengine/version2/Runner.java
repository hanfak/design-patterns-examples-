package enterprisepatterns.validationengine.version2;

public class Runner {
  public static void main(String... args) {
    // Returns standard exception when at least one validation check fails
//    StringArgumentValidator stringArgumentValidator = new StringArgumentValidator();
//    System.out.println("validatedInput1 = " + stringArgumentValidator.validateBookReference("Hello, my email is bob.duke@google.com"));
//    System.out.println("validatedInput2 = " + stringArgumentValidator.validateBookReference("Hallo, my email is bob.duke@google.com"));

//    StringArgumentValidator1 stringArgumentValidator1 = new StringArgumentValidator1();
//    System.out.println("validatedInput1 = " + stringArgumentValidator1.validate("Hello, my email is bob.duke@google.com"));
//    System.out.println("validatedInput2 = " + stringArgumentValidator1.validate("Hallo, my email is bob.duke@google.com"));

//    StringArgumentValidator2 stringArgumentValidator2 = new StringArgumentValidator2();
//    System.out.println("validatedInput1 = " + stringArgumentValidator2.validate("Hello, my email is 3"));
//    System.out.println("validatedInput2 = " + stringArgumentValidator2.validate("Hello, my email is bob.duke@google.com"));
//    System.out.println("validatedInput3 = " + stringArgumentValidator2.validate("Hallo, my email is 3"));
//    System.out.println("validatedInput4 = " + stringArgumentValidator2.validate(null));

//    StringArgumentValidator3 stringArgumentValidator3 = new StringArgumentValidator3();
//    System.out.println("validatedInput1 = " + stringArgumentValidator3.validate("Hello, my email is 3"));
//    System.out.println("validatedInput2 = " + stringArgumentValidator3.validate("Hello, my email is bob.duke@google.com"));
//    System.out.println("validatedInput3 = " + stringArgumentValidator3.validate("Hallo, my email is 3"));
//    System.out.println("validatedInput4 = " + stringArgumentValidator3.validate("Hallo, my email is fasd"));

    StringArgumentValidator4 stringArgumentValidator4 = new StringArgumentValidator4();
    System.out.println("validatedInput1 = " + stringArgumentValidator4.validate("Hello, my email is 3"));
    System.out.println("validatedInput2 = " + stringArgumentValidator4.validate("Hello, my email is bob.duke@google.com"));
    System.out.println("validatedInput3 = " + stringArgumentValidator4.validate("Hallo, my email is 3"));
    System.out.println("validatedInput4 = " + stringArgumentValidator4.validate("Hallo, my email is fasd"));
  }
}
