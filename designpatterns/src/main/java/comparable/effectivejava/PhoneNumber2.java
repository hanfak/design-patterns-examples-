package comparable.effectivejava;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneNumber2 implements Comparable<PhoneNumber2> {
  private final int areaCode;
  private final int number;

  private PhoneNumber2(int areaCode, int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public static PhoneNumber2 of(int areaCode, int number) {
    return new PhoneNumber2(areaCode, number);
  }

  // We do the comparator once
  private static final Comparator<PhoneNumber2> COMPARATOR = Comparator.comparingInt((PhoneNumber2 p) -> p.areaCode)
          .thenComparingInt(p -> p.number);

  @Override
  public int compareTo(PhoneNumber2 o) {
    return COMPARATOR.compare(this, o);
  }

  public static void main(String... args) {
    PhoneNumber2 p1 = PhoneNumber2.of(123, 12345);
    PhoneNumber2 p2 = PhoneNumber2.of(124, 12345);
    PhoneNumber2 p3 = PhoneNumber2.of(124, 12343);
    // immutable way of sorting list, no need to pass in the comparator to sorted()
    List<PhoneNumber2> sorted = Stream.of(p1, p2, p3).sorted().collect(Collectors.toList());
    System.out.println("sorted = " + sorted);
  }

  @Override
  public String toString() {
    // intellij impl
    return "PhoneNumber{" +
            "areaCode=" + areaCode +
            ", number=" + number +
            '}';
  }
}
