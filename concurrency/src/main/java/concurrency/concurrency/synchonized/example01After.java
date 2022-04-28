package concurrency.concurrency.synchonized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class example01After {
  public static void main(String... args) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(3);
    SynchronizedMethods1 method = new SynchronizedMethods1();

    IntStream.range(0, 1000)
        .forEach(count -> service.submit(method::calculate));
    service.awaitTermination(1000, TimeUnit.MILLISECONDS);
    System.out.println(method.getSum() == 1000);
    System.out.println(method.getSum());
    service.shutdown();
  }
}

class SynchronizedMethods1 {

  private int sum = 0;

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  //Instance methods are synchronized over the instance of the class owning the method.
  // Which means only one thread per instance of the class can execute this method.
  public synchronized void calculate() {
    setSum(getSum() + 1);
  }

}