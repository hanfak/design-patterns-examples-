package mappings.version1.usecase.port.in;

public interface UseCaseInterface {
  UseCaseResultModel execute(UseCaseCommand command);

  class UseCaseCommand {
    // Can have validation in here
    public final String someStateOne;
    public final Integer someStateTwo;

    public UseCaseCommand(String someStateOne, Integer someStateTwo) {
      this.someStateOne = someStateOne;
      this.someStateTwo = someStateTwo;
    }
  }

  class UseCaseResultModel {
    public final String result;

    public UseCaseResultModel(String result) {
      this.result = result;
    }
  }
}
