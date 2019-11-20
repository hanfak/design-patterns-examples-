package effectivejava.tostring;

public class PhoneNumber {
  private final int areaCode;
  private final int number;

  private PhoneNumber(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber of(int areaCode, int number) {
    return new PhoneNumber(areaCode, number);
  }

  // This is good for debugging
  // Should not be used for sending to user, as it may need to be localised, formatted etc
  @Override
  public String toString() {
    // intellij impl
    return "PhoneNumber{" +
            "areaCode=" + areaCode +
            ", number=" + number +
            '}';
  }
}
