package javalibraries.tostring.effectivejava.formatter;

import java.util.Formattable;

public class PhoneNumber implements Formattable {
  private final int areaCode;
  private final int number;

  private PhoneNumber(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber of(int areaCode, int number) {
    return new PhoneNumber(areaCode, number);
  }

  public int getAreaCode() {
    return areaCode;
  }

  public int getNumber() {
    return number;
  }

  // should be added if this object will be returned to user
  @Override
  public void formatTo(java.util.Formatter formatter, int flags, int width, int precision) {
    formatter.format("%d-%d", areaCode, number); // makes String.format args simpler
  }

  // becareful, if not provided any getters, then user may want the field, and will use string version
  // delimeter to extract the field value. But this can change with out them knowing, and no compileerrors will help

  public static void main(String... args) {
    System.out.println(String.format("%s", PhoneNumber.of(123, 5423432)));
  }
}
