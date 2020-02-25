package functional.combinatorpattern;

import functional.combinatorpattern.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static functional.combinatorpattern.CustomerRegistrationValidator.isAnAdult;
import static functional.combinatorpattern.CustomerRegistrationValidator.isEmailValid;
import static functional.combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;

public class Runner2 {

  public static void main(String... args) {

    Customer customer = new Customer(
            "Alice",
            "alice@gmail.com",
            "+0898787879878",
            LocalDate.of(2015, 1, 1)
    );

    // New way

    // Using combinator pattern
    // Can chain the rules, order is not important
    ValidationResult result = isEmailValid()
            .and(isPhoneNumberValid())
            .and(isAnAdult())
            .apply(customer);

    System.out.println(result);

    if (result != ValidationResult.SUCCESS) {
      throw new IllegalStateException(result.name());
    }

    if (result == ValidationResult.SUCCESS) {
      System.out.println("Do something in flow");
    }
    // if the above is valid we can store customer in db

    /**
     *
     * Can return some object, which implements some interface instead of an enum
     * This can be added to some object that a service returns, after all the predicates are passed
     */
  }
}

