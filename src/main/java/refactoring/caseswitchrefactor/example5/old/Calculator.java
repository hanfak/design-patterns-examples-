package refactoring.caseswitchrefactor.example5.old;

public class Calculator {
  // This is a simple example, so it's not bad, also ok if number of if's is small
  // issues occurs
  //  - when block contains complex logic
  //  - when number of ifs increases
  public int calculate(int a, int b, String operator) {
    int result = Integer.MIN_VALUE;

    if ("add".equals(operator)) {
      result = a + b;
    } else if ("multiply".equals(operator)) {
      result = a * b;
    } else if ("divide".equals(operator)) {
      result = a / b;
    } else if ("subtract".equals(operator)) {
      result = a - b;
    }
    return result;
  }
}
