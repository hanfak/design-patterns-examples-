package comparable.effectivejava;

import com.google.common.collect.ComparisonChain;

// Should implement Comparable, if this object has a natural ordering between the same objects.
// Makes comparing and sorting easier
public class PhoneNumber implements Comparable<PhoneNumber> {
  private final int areaCode;
  private final int number;

  private PhoneNumber(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber of(int areaCode, int number) {
    return new PhoneNumber(areaCode, number);
  }


  @Override
  public int compareTo(PhoneNumber o) {
    // Guava impl
    return ComparisonChain.start()
            .compare(this.areaCode, o.areaCode)
            .compare(this.number, o.number)
            .result();
  }
}
