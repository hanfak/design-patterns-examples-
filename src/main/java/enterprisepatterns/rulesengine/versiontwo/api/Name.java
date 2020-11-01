package enterprisepatterns.rulesengine.versiontwo.api;

public class Name {
  private final String value;

  private Name(String value) {
    this.value = value;
  }

  public static Name ruleName(String value) {
    return new Name(value);
  }

  public String getName() {
    return value;
  }
}
