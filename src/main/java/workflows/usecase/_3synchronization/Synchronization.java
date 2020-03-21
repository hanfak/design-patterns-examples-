package workflows.usecase._3synchronization;

import workflows.usecase.ParallelProcessor;
import workflows.usecase.Repository;
import workflows.usecase.Service;

import java.util.Arrays;
import java.util.List;

public class Synchronization {
  private final ParallelProcessor<String> parallelProcessor;
  private final Service service;
  private final Repository repository;

  public Synchronization(ParallelProcessor<String> parallelProcessor, Service service, Repository repository) {
    this.parallelProcessor = parallelProcessor;
    this.service = service;
    this.repository = repository;
  }

  public void execute(String input) {
    // Example 1 - using callables
    // Step 1 - Start all processors
    List<String > process = parallelProcessor.process(Arrays.asList(
            () -> service.sendSomething(input),
            () -> service.sendSomethingElse(input)));

    // Step 2 - when all processes are finished, then do something with it
    process.forEach(System.out::println);

    // Example 2 - using runnables
    // Step 1 - Start all processors
    Boolean processed = parallelProcessor.process2(
            () -> service.send(input.length()),
            () -> repository.storeSomething(input));

    // Step 2 - when all processes are finished, then do something with it
    if (processed) {
      process.forEach(System.out::println);
    }
  }
}
