package workflows.usecase._2andsplit;

import workflows.usecase.ParallelProcessor;
import workflows.usecase.Repository;
import workflows.usecase.Rules;
import workflows.usecase.Service;

public class AndSplitUsecase {
  private final Repository repository;
  private final Rules rules;
  private final Service service;
  private final ParallelProcessor parallelProcessor;

  public AndSplitUsecase(Repository repository, Rules rules, Service service, ParallelProcessor parallelProcessor) {
    this.repository = repository;
    this.rules = rules;
    this.service = service;
    this.parallelProcessor = parallelProcessor;
  }

  public void execute(String input) {
    // Step 1
    Integer result = rules.process(input);

    // Step 2 - process multiple steps in parallel withouut waiting for result after some set of steps
    parallelProcessor.process(
            () -> service.send(result),
            () -> repository.storeSomething(input));
  }
}
