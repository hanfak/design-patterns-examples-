package refactoring.caseswitchrefactor.example5.rulesengine;

public class MultiplicationRule implements Rule {

  @Override
  public boolean matches(Operator expression) {
    return expression == Operator.MULTIPLY;
  }

  @Override
  public Result evaluate(Expression expression) {
    return new Result(expression.getX() * expression.getY());
  }
}
