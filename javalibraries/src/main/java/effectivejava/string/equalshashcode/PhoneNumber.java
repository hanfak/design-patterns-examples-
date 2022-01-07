package effectivejava.string.equalshashcode;

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

  // Original implementation
  // Always implement these for value objects
  @Override
  public boolean equals(Object o) {
    return super.equals(o); // compares on object reference
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
