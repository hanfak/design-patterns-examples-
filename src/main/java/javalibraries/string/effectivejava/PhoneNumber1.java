package javalibraries.string.effectivejava;

import com.google.common.base.MoreObjects;

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

  @Override
  public String toString() {
    // quava impl
    return MoreObjects.toStringHelper(this)
            .add("areaCode", areaCode)
            .add("number", number)
            .toString();  }
}
