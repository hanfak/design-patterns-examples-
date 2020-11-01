package enterprisepatterns.rulesengine.versiontwo.api;

public class FactsBuilder {
  private FactsBuilder() {
  }

  public static FactsBuilder factsBuilder() {
    return new FactsBuilder();
  }

}
