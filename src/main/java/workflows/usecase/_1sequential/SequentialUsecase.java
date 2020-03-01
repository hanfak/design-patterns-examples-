package workflows.usecase._1sequential;

import workflows.usecase.Repository;
import workflows.usecase.Rules;
import workflows.usecase.Service;

import java.util.Optional;

public class SequentialUsecase {

  private final Repository repository;
  private final Rules rules;
  private final Service service;

  public SequentialUsecase(Repository repository, Rules rules, Service service) {
    this.repository = repository;
    this.rules = rules;
    this.service = service;
  }

  public void execute() {
    // Step One
    Optional<String> someOptionalData = repository.doSomething();

    // Step Two
    String someData = someOptionalData.orElseThrow(IllegalStateException::new);

    //Step Three
    Integer rulesOutput = rules.process(someData);

    // Step Four
    Integer result = repository.doSomethingElse(rulesOutput);

    // Step Five
    service.send(result);
  }
}
