package effectivejava.factorymethods;
// Value object
public class PhoneNumber {
  private static final PhoneNumber COMMON = new PhoneNumber(123, 1234);
  // Final restrict mutability
  private final int areaCode;
  private final int number;

  // Should be used for a max of three params, but this is opinion
  private PhoneNumber(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  // Use static factory methods
  // Only this class can create an instance of this object
  // Can have several factory methods and give appropriate names the
  // They dont have to return a new instance every time
  public static PhoneNumber of(int areaCode, int number) {// Dont need to return impl, can return the interface or it's chlidren
    return new PhoneNumber(areaCode, number);
  }
  // if newing up the object is expensive can set it as a static constant
  // flyway pattern
  public static PhoneNumber common(int areaCode, int number) {
    if (areaCode == 123 && number == 1234) {
      return COMMON;
    }
    return new PhoneNumber(areaCode, number);
  }

  public static void main(String... args) {
    PhoneNumber common = PhoneNumber.of(123, 1234);
    PhoneNumber common2 = PhoneNumber.of(123, 1234);
    System.out.println(common == common2); // flyway pattern allows to use ==
  }
}
