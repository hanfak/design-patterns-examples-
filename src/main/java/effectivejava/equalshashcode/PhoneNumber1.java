package effectivejava.equalshashcode;

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
  public boolean equals(Object obj) {
    if (obj == this) return true; // This shortcircuits the check that the same object is being checked, especially good if many fields

    // Can just do this
    if (obj instanceof PhoneNumber) {
      PhoneNumber1 other = (PhoneNumber1) obj;
      return Objects.equals(this.areaCode, other.areaCode) // useful for objects, helps with null
              && this.number == other.number; // use == for primitives, better performance, due boxing ofthe primitives
    }
    return false;
  }
 // Must always implement hashcode and equals together
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
