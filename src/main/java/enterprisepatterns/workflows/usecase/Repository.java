package enterprisepatterns.workflows.usecase;

import java.util.Optional;

public interface Repository {
  Optional<String> doSomething();

  Integer doSomethingElse(Integer input);

  void storeSomething(String input);
}
