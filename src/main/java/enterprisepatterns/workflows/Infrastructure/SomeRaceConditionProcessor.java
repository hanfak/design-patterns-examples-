package enterprisepatterns.workflows.Infrastructure;

import enterprisepatterns.workflows.usecase.ComplexCalculator.UseCaseResultModel;
import enterprisepatterns.workflows.usecase.RaceConditionProcessor;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

public class SomeRaceConditionProcessor implements RaceConditionProcessor<UseCaseResultModel> {

  @Override
  public UseCaseResultModel process(List<Callable<UseCaseResultModel>> callables) {
    ExecutorService threadPool = Executors.newFixedThreadPool(callables.size());
    ExecutorCompletionService<UseCaseResultModel> service = new ExecutorCompletionService<>(threadPool);
    Instant start = Instant.now();

    List<Future<UseCaseResultModel>> results = callables.stream()
            .map(service::submit)
            .collect(toList());
    UseCaseResultModel result = null;

    for (int i = 0; i < results.size(); i++) {
      try {
        UseCaseResultModel result1 = service.take().get();
        if (result1 != null) {
          result = result1;
          System.out.println("Result: " + result.result + "  " + result.calculationResult);
          break;
        }

      } catch (InterruptedException | ExecutionException e) {
        throw new IllegalArgumentException();
      }
    }
    awaitTerminationAfterShutdown(threadPool);
    Instant finish = Instant.now();
    Duration duration = Duration.between(start, finish);
    long nano = duration.getNano();
    System.out.println("nano = " + nano);
    return result;
  }

  // TODO implement polling instead
//  boolean firstCompleted = false;
//while (!firstCompleted)
//{
//    try
//    {
//        Future<Integer> future = completionService.poll();
//        if (future != null)
//        {
//            Integer firstResult = future.get();
//            System.out.println(firstResult);
//            firstCompleted = true;
//        }
//    } catch (NullPointerException | InterruptedException | ExecutionException ex)
//    {
//        System.err.println(ex.getMessage());
//    }
//}
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

// TODO implement it using java 8???
// replace for loop
//    UseCaseResultModel useCaseResultModel = IntStream.range(0, results.size())
//            .mapToObj(i -> {
//                      try {
//                        return service.take().get();
//                      } catch (InterruptedException | ExecutionException e) {
//                        throw new IllegalArgumentException();
//                      }
//                    }
//            )
//            .filter(Objects::isNull)
//            .findFirst().get();