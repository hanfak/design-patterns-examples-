package refactoring.caseswitchrefactor.example5.rulesengine;

public class Calculator {
  public int calculate(Expression expression1) {
    Expression expression = expression1;
    RuleEngine engine = new RuleEngine();
    Result result = engine.process(expression);
    return result.getValue();
  }
}
