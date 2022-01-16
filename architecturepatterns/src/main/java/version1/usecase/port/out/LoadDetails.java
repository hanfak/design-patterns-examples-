package version1.usecase.port.out;

public interface LoadDetails {

  LoadDetailsResult loadDetails(Id id);

  class Id {
    public final int value;

    public Id(int value) {
      this.value = value;
    }
  }

  class LoadDetailsResult {

    public final String someStateOne;
    private final int someStateTwo;
    private final boolean someStateThree;

    public LoadDetailsResult(String someStateOne, int someStateTwo, boolean someStateThree) {
      this.someStateOne = someStateOne;
      this.someStateTwo = someStateTwo;
      this.someStateThree = someStateThree;
    }
  }
}
