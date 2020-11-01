package enterprisepatterns.rulesengine.versiontwo.api;

import java.util.List;

public class Rule {

  private final List<Condition> condition;
  private final Action action;
  private final Name name;

  public Rule(List<Condition> condition, Action action, Name name) {
    this.condition = condition;
    this.action = action;
    this.name = name;
  }

  public void perform(Facts facts) {
    if (condition.stream()
            .allMatch(condition -> condition.evaluate(facts))) {
      action.execute(facts);
    }
//
//
//    if (condition.evaluate(facts)) {
//      action.execute(facts);
//    }
  }

  public String getName() {
    return name.getName();
  }
}
