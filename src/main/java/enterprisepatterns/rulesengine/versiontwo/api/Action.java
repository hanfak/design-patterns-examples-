package enterprisepatterns.rulesengine.versiontwo.api;

@FunctionalInterface
public interface Action{
    void execute(Facts facts);
}
