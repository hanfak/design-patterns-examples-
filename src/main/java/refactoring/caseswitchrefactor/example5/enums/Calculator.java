package refactoring.caseswitchrefactor.example5.enums;

import refactoring.caseswitchrefactor.example5.command.Command;

public class Calculator {
  public int calculate(int a, int b, Operator operator) {
    return operator.apply(a, b);
  }
}
