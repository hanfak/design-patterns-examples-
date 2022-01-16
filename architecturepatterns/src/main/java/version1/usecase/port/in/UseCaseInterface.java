package version1.usecase.port.in;

public interface UseCaseInterface {

  UseCaseResultModel execute(UseCaseCommand command);

  class UseCaseCommand {
    // Can have validation in here
    public final String someStateOne;
    public final int someStateTwo;
    // Can use static factory
    public UseCaseCommand(String someStateOne, int someStateTwo) {
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
