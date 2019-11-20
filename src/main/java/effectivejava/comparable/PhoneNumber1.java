package effectivejava.comparable;

import java.util.Comparator;

public class PhoneNumber1 implements Comparable<PhoneNumber1> {
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
  public int compareTo(PhoneNumber1 o) {
    // From java 8
    return Comparator.comparingInt((PhoneNumber1 p) -> p.areaCode) // compare area code first
            .thenComparingInt(p -> p.number)
            .compare(this, o);
  }
}
