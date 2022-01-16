package version1.usecase.port.out;

public interface WriteDetails {

  void writeDetails(WriteDetailsCommand writeDetailsCommand);

  class WriteDetailsCommand {

    private final String someStateOne;
    private final int someStateTwo;
    private final boolean someStateThree;

    public WriteDetailsCommand(String someStateOne, int someStateTwo, boolean someStateThree) {
      this.someStateOne = someStateOne;
      this.someStateTwo = someStateTwo;
      this.someStateThree = someStateThree;
    }
  }
}
