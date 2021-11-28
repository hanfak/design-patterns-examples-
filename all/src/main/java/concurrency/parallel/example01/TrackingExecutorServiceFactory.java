package concurrency.parallel.example01;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.concurrent.TimeUnit.MINUTES;

public class TrackingExecutorServiceFactory  {

  private final ThreadFactory threadFactory;

  private List<ExecutorService> tracked = new ArrayList<>();

  public TrackingExecutorServiceFactory(LoggingUncaughtExceptionHandler loggingUncaughtExceptionHandler) {
    this.threadFactory = new ThreadFactoryBuilder()
        .setUncaughtExceptionHandler(loggingUncaughtExceptionHandler)
        .setNameFormat("airport-executor-thread-%d")
        .build();
  }

  public ExecutorService newFixedThreadPool(int size) {
    ExecutorService executorService = Executors.newFixedThreadPool(size, threadFactory);
    tracked.add(executorService);
    return executorService;
  }

  void shutdown() throws InterruptedException {
    for (ExecutorService executorService : tracked) {
      executorService.shutdown();
    }
    for (ExecutorService executorService : tracked) {
      executorService.awaitTermination(1, MINUTES);
    }
  }
}