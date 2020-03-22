package enterprisepatterns.workflows.Infrastructure;

import enterprisepatterns.workflows.usecase.Repository;

import java.util.Optional;

public class SomeRepository implements Repository {
  @Override
  public Optional<String> doSomething() {
    return null;
  }

  @Override
  public Integer doSomethingElse(Integer input) {
    return null;
  }

  @Override
  public void storeSomething(String input) {

  }
}
