package architecturepatterns.mappings.version1.usecase.port.out;

public interface LoadDetails {
  DataproviderLoadDetailsModel loadDetails(Id id);

  class DataproviderLoadDetailsModel {
    public final String someStateOne;
    private final Integer someStateTwo;
    private final boolean someStateThree;

    public DataproviderLoadDetailsModel(String someStateOne, Integer someStateTwo, boolean someStateThree) {
      this.someStateOne = someStateOne;
      this.someStateTwo = someStateTwo;
      this.someStateThree = someStateThree;
    }
  }

  class Id {
    public final Integer value;

    public Id(Integer value) {
      this.value = value;
    }
  }
}
