package refactoring.caseswitchrefactor.example5.factory;

public class Calculator {
  public int calculate(int a, int b, String operator) {
    return OperatorFactory
        .getOperation(operator)
        .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"))
        .apply(a, b);
  }
}
