package designpatterns.factory.factorymethods;

import com.google.common.base.Preconditions;

// Value object
public class PhoneNumber1 {
  private final int areaCode;
  private final int number;
  private final String name;

  private PhoneNumber1(int areaCode, int number, String name) {
    this.areaCode = areaCode;
    this.number = number;
    this.name = name;
  }
  // Always good to have validation on the inputs, but depends on the system
  // Bugs that occur and are hard to find, are when the system reaches an inconsistent state, validation helps
  public static PhoneNumber1 of(int areaCode, int number, String name) {
    // Can check null values, empty strings
    Preconditions.checkArgument(areaCode > 100, "Should be over 100"); // Can check values pass some predicate other wise throw exception
    Preconditions.checkNotNull(name);
    return new PhoneNumber1(areaCode, number, name);
  }
}
