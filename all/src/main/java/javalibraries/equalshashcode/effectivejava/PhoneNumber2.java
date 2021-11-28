package javalibraries.equalshashcode.effectivejava;

import com.google.common.base.Objects;

public class PhoneNumber2 {
  private final int areaCode;
  private final int number;

  private PhoneNumber2(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber2 of(int areaCode, int number) {
    return new PhoneNumber2(areaCode, number);
  }

  // Guava impl
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PhoneNumber2 that = (PhoneNumber2) o;
    return areaCode == that.areaCode &&
            number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(areaCode, number);
  }
}
