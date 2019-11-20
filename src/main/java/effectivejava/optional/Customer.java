package effectivejava.optional;

import java.util.Optional;

public class Customer {
  // state that field can return null
  /**
   *
   */
  private String title; // Instead of using Optional as field can use a getter which returns optional


  public Optional<String> getTitle() {
    return Optional.ofNullable(title);
  }

  // Optional cannot be used in java bean for orm
}
