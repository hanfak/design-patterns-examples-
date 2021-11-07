package refactoring.caseswitchrefactor.example5.rulesengine;

import java.util.List;

public class RuleEngine {
  private static final List<Rule> rules = List.of(
      new AddRule(),
      new MultiplicationRule()
  );

  public Result process(Expression expression) {
    Rule rule = rules
        .stream()
        .filter(r -> r.matches(expression.getOperator()))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Expression does not matches any Rule"));
    return rule.evaluate(expression);
  }
}
