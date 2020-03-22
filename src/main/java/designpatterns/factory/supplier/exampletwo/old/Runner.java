package designpatterns.factory.supplier.exampletwo.old;

import designpatterns.factory.supplier.exampletwo.Computation;

/**
 * This is also a form of designpatterns.strategy pattern
 *
 */
public class Runner {
  public static void main(String[] args) {
    Computation computation;

    computation = new SlowComputation();
    long SlowComputationResult = computation.sum1To(100L);
    System.out.println("SlowComputationResult = " + SlowComputationResult);

    computation = new FastComputation();
    long fastComputationResult = computation.sum1To(100L);
    System.out.println("fastComputationResult = " + fastComputationResult);

  }
}
