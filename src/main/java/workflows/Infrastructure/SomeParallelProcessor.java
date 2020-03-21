package workflows.Infrastructure;

import workflows.usecase.ParallelProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

public class SomeParallelProcessor implements ParallelProcessor<String> {
  @Override
  public void process(Runnable... runnables) {
    ExecutorService threadPool = Executors.newFixedThreadPool(runnables.length);
    Arrays.stream(runnables).forEach(threadPool::execute);
    awaitTerminationAfterShutdown(threadPool);
  }

  @Override
  public Boolean process2(Runnable... runnables) {
    ExecutorService threadPool = Executors.newFixedThreadPool(runnables.length);
    // To ensure all actions completed
    List<? extends Future<?>> results = Arrays.stream(runnables).map(threadPool::submit).collect(toList());
    awaitTerminationAfterShutdown(threadPool);
    return results.stream().allMatch(Future::isDone);
  }

  @Override
  public List<String> process(List<Callable<String>> callables) {
    ExecutorService threadPool = Executors.newFixedThreadPool(callables.size());
    try {
      List<Future<String>> results = threadPool.invokeAll(callables); // blocking so all actions will complet first
      awaitTerminationAfterShutdown(threadPool);
      return results.stream()
              .map(this::getFuture)
              .collect(toList());
    } catch (InterruptedException e) {
      throw new IllegalStateException();
    }
  }

  private String getFuture(Future<String> future) {
    try {
      return future.get();
    } catch (InterruptedException | ExecutionException e) {
      throw new IllegalStateException();
    }
  }

  public void awaitTerminationAfterShutdown(ExecutorService threadPool) {
    threadPool.shutdown();
    try {
      if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
        threadPool.shutdownNow();
      }
    } catch (InterruptedException ex) {
      threadPool.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }
}
