package enterprisepatterns.workflows.usecase._4xorsplit;

import enterprisepatterns.workflows.usecase.Repository;
import enterprisepatterns.workflows.usecase.Rules;
import enterprisepatterns.workflows.usecase.Service;

import java.util.Optional;

public class XOrSplitUsecase {

  private final Repository repository;
  private final Rules rules;
  private final Service service;

  public XOrSplitUsecase(Repository repository, Rules rules, Service service) {
    this.repository = repository;
    this.rules = rules;
    this.service = service;
  }

  public void execute() {
    // Step One
    Optional<String> someOptionalData = repository.doSomething();

    // Step Two
    String someData = someOptionalData.orElseThrow(IllegalStateException::new);

    // Step Three - dependent on the previous results, it will make a decision between different paths
    // this can be two paths (if), or multiple paths (case/switch)
    // Can be done via type ie polymorphism
    // Can be done via rules engine
    // Where each branch it goes on to, runs a set of actions/workflows
    if (someData.equals("match")) {
      Integer rulesOutput = rules.process(someData);
      Integer result = repository.doSomethingElse(rulesOutput);
      service.send(result);
    } else {
      repository.storeSomething(someData);
    }
  }
}
