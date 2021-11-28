package designpatterns.gangoffour.factory.supplier.exampletwo.better;

import designpatterns.gangoffour.factory.supplier.exampletwo.Computation;

import java.util.function.Supplier;

public class Runner {

  public static void main(String[] args) {
    final Supplier<Computation> slowFactory = () -> n -> {
      long rv = 0L;
      for (long i = 1; i <= n; ++i) {
        rv += i;
      }
      return rv;
    };

    final Supplier<Computation> gaussFactory = () -> n -> (n * (n+1))/2;

    System.out.println(slowFactory.get().sum1To(100L));
    System.out.println(gaussFactory.get().sum1To(100L));
  }
}
