package javalibraries.equalshashcode.effectivejava;


import java.util.Objects;

public class PhoneNumber4 {
  private final int areaCode;
  private final int number;

  private PhoneNumber4(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber4 of(int areaCode, int number) {
    return new PhoneNumber4(areaCode, number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PhoneNumber4 that = (PhoneNumber4) o;
    return areaCode == that.areaCode &&
            number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(areaCode, number);
  }
}
