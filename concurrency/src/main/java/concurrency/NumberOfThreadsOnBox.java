package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfThreadsOnBox {
  private static AtomicInteger atomicInteger = new AtomicInteger(0);

  public static void main(String args[]) {

    while (true) {
      Thread t1 = new Thread() {
        public void run() {
          try {
            System.out.println("Started thread " + atomicInteger.incrementAndGet());
            TimeUnit.MINUTES.sleep(10);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      };

      t1.start();
    }
  }

}
