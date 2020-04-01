package designpatterns.factory.supplier.exampletwo.old;

import designpatterns.factory.supplier.exampletwo.Computation;

public class FastComputation implements Computation {
  @Override
  public long sum1To(long n) {
    return (n * (n+1)) / 2;
  }
}