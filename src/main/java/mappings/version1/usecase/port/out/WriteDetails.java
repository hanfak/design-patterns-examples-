package mappings.version1.usecase.port.out;

public interface WriteDetails {
  void writeDetails(DataproviderCommand dataproviderCommand);

  class DataproviderCommand {
    private final String someStateOne;
    private final Integer someStateTwo;
    private final boolean someStateThree;

    public DataproviderCommand(String someStateOne, Integer someStateTwo, boolean someStateThree) {
      this.someStateOne = someStateOne;
      this.someStateTwo = someStateTwo;
      this.someStateThree = someStateThree;
    }
  }
}
