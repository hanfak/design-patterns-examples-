package javalibraries.equalshashcode.effectivejava;

import java.util.Objects;

public class PhoneNumber1 {
  private final int areaCode;
  private final int number;

  private PhoneNumber1(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber1 of(int areaCode, int number) {
    return new PhoneNumber1(areaCode, number);
  }

  // To create equals, we compare on the state of the objects, each field is compared between the two objects
  @Override
  public boolean equals(Object o) {
    if (this == o) return true; // This shortcircuits the check that the same object is being checked, especially good if many fields
    if (o == null || getClass() != o.getClass()) return false;

    PhoneNumber1 that = (PhoneNumber1) o;

    return Objects.equals(this.areaCode, that.areaCode) // useful for objects, helps with null
              && this.number == that.number; // use == for primitives, better performance, due boxing ofthe primitives
  }

  // Must always implement hashcode and equals together
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
