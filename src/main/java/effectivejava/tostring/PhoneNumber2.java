package effectivejava.tostring;


import org.apache.commons.lang3.builder.ToStringBuilder;

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

  // apache commons lang impl
  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("areaCode", areaCode)
            .append("number", number)
            .toString();
  }
}
