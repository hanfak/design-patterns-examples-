package concurrency.concurrency.synchonized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class example01Before {
  public static void main(String... args) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(3);
    SynchronizedMethods summation = new SynchronizedMethods();

    IntStream.range(0, 1000)
        .forEach(count -> service.submit(summation::calculate));
    service.awaitTermination(1000, TimeUnit.MILLISECONDS);
    System.out.println(summation.getSum() == 1000);
    System.out.println(summation.getSum());
    service.shutdown();
  }
}

class SynchronizedMethods {

  private int sum = 0;

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public void calculate() {
    setSum(getSum() + 1);
  }

}