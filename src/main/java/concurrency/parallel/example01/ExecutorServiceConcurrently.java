package concurrency.parallel.example01;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

// Happy path is tested via integration test, but can be tested via unit test
public class ExecutorServiceConcurrently {

  private final ExecutorService executorService;

  public ExecutorServiceConcurrently(TrackingExecutorServiceFactory executorServiceFactory, int size) {
    this.executorService = executorServiceFactory.newFixedThreadPool(size);
  }

  public <T> List<T> execute(List<? extends Callable<T>> toExecute) {
    List<T> result = executeConcurrently(toExecute).stream().map(this::get).collect(Collectors.toList());
    executorService.shutdown();
    return result;
  }

  private <T> T get(Future<T> future) {
    try {
      return future.get();
    } catch (InterruptedException | ExecutionException e) {
      throw new IllegalStateException(e);
    }
  }

  private <T> List<Future<T>> executeConcurrently(List<? extends Callable<T>> callables) {
    try {
      return executorService.invokeAll(callables);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }
}