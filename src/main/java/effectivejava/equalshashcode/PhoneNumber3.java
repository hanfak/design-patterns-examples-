package effectivejava.equalshashcode;


import java.util.Objects;

public class PhoneNumber3 {
  private final int areaCode;
  private final int number;
  private int hashCode;

  private PhoneNumber3(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber3 of(int areaCode, int number) {
    return new PhoneNumber3(areaCode, number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PhoneNumber3 that = (PhoneNumber3) o;
    return areaCode == that.areaCode &&
            number == that.number;
  }

  // lazy impl
  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = Objects.hash(this.areaCode, this.number);
    }
    this.hashCode = result;
    return result;
  }
}
