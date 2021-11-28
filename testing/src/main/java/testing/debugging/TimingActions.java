package testing.debugging;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TimingActions {
  public static void main(String... args) {
    long start = System.nanoTime();
    List<BigInteger> squares = new ArrayList<>();
    for (int i = 0; i <10_000_000; i++) {
      squares.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(i)));
    }
    BigInteger last = squares.get(9_999_999);
    System.out.println("last = " + last);
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("invocationTime = " + invocationTime);
  }
}
