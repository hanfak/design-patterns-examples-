package enterprisepatterns.rulesengine.versiontwo.api;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
