package factory.supplier.exampletwo.old;

import factory.supplier.exampletwo.Computation;

public class SlowComputation implements Computation {
  @Override
  public long sum1To(long n) {
    long rv = 0L;
    for (long i = 1; i <= n; ++i) {
      rv += i;
    }
    return rv;
  }
}
