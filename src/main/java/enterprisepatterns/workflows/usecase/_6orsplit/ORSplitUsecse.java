package enterprisepatterns.workflows.usecase._6orsplit;

import enterprisepatterns.workflows.usecase.ParallelProcessor;
import enterprisepatterns.workflows.usecase.Repository;
import enterprisepatterns.workflows.usecase.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

public class ORSplitUsecse {

  private final ParallelProcessor<String> parallelProcessor;
  private final Service service;
  private final Repository repository;

  public ORSplitUsecse(ParallelProcessor<String> parallelProcessor, Service service, Repository repository) {
    this.parallelProcessor = parallelProcessor;
    this.service = service;
    this.repository = repository;
  }

  public void execute(String input) {
    // Step 0 - Some action that under completion or return of result determines next step
    // If completion, then time to complete and/or non completion might decide what will happen
    // If result, then what is in result decides what will happen

    // Step 1 - Depending on the input, it will either do action A, or B, or both
    List<String> result = new ArrayList<>();
    switch(input) {
      case "a":
        result.add(service.sendSomething(input));
        break;
      case "b":
        result.add(service.sendSomethingElse(input));
        break;
      default:
        result.addAll(parallelProcessor.process(Arrays.asList(
                () -> service.sendSomething(input),
                () -> service.sendSomethingElse(input))));
        break;
    }
    // Same as above but for java 12+
    List<String> result1 = switch(input) {
      case "a" -> singletonList(service.sendSomething(input));
      case "b" -> singletonList(service.sendSomethingElse(input));
      default -> parallelProcessor.process(Arrays.asList(
              () -> service.sendSomething(input),
              () -> service.sendSomethingElse(input)));
    };

  }
}
