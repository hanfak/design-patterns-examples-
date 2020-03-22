package architecturepatterns.mappings.version1.entryprovider;

import architecturepatterns.mappings.version1.usecase.port.in.UseCaseInterface;
import architecturepatterns.mappings.version1.usecase.port.in.UseCaseInterface.UseCaseCommand;

public class Controller {
  private final UseCaseInterface useCase;

  public Controller(UseCaseInterface useCase) {
    this.useCase = useCase;
  }

  public String handle(String request) {
    UseCaseCommand command = new UseCaseCommand(request, 1);
    return useCase.execute(command).result;
  }
}
