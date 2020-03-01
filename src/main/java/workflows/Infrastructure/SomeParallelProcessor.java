package workflows.Infrastructure;

import workflows.usecase.ParallelProcessor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SomeParallelProcessor implements ParallelProcessor {
  @Override
  public void process(Runnable... runnables) {
    ExecutorService threadPool = Executors.newFixedThreadPool(runnables.length);
    Arrays.stream(runnables).forEach(threadPool::execute);
    threadPool.shutdown();
    try {
      threadPool.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
