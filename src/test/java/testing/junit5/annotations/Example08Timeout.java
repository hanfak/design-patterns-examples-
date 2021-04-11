package testing.junit5.annotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Example08Timeout {
  //https://junit.org/junit5/docs/5.5.0-RC2/api/org/junit/jupiter/api/Timeout.html
  @Test
  @Timeout(value = 42, unit = MILLISECONDS)
  public void testInfiniteTimeTakingLoop() throws InterruptedException {
    while (true) {
      Thread.currentThread().sleep(1000);
    }
  }
}
