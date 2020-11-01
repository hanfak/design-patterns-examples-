package enterprisepatterns.rulesengine.versiontwo.api;

import java.util.ArrayList;
import java.util.List;

public class RuleBuilder {

  private List<Condition> condition = new ArrayList<>();
  private Name name;

  private RuleBuilder(Name name) {
    this.name = name;
  }

  public static RuleBuilder forARuleWithName(Name name) {
    return new RuleBuilder(name);
  }

  public static RuleBuilder forARule() {
    return new RuleBuilder(null);
  }

  public RuleBuilder withName(Name name) {
    this.name = name;
    return this;
  }

  public RuleBuilder whenItMeetsCondition(Condition condition) {
    this.condition.add(condition);
    return this;
  }

  public RuleBuilder andWhenItMeetsCondition(Condition condition) {
    this.condition.add(condition);
    return this;
  }

  public Rule thenTheActionIsTaken(Action action) {
    return new Rule(condition, action, name);
  }
}