package enterprisepatterns.workflows.Infrastructure;

import enterprisepatterns.workflows.usecase.Service;

public class SomeService implements Service {
  @Override
  public Response send(Integer input) {
    return null;
  }

  @Override
  public String sendSomething(String length) {
    return null;
  }

  @Override
  public String sendSomethingElse(String input) {
    return null;
  }
}
