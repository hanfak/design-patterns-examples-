package functional.combinatorpattern;

import java.time.LocalDate;

/**
 * Using the combinator pattern to implement a rules engine, or validation
 *
 */
public class Runner {
  public static void main(String[] args) {
    Customer customer = new Customer(
            "Alice",
            "alice@gmail.com",
            "+0898787879878",
            LocalDate.of(2015, 1, 1)
    );
    // The general way of doing.
    System.out.println(new CustomerValidatorService().isValid(customer));
    // if the above is valid we can store customer in db

  }
}
