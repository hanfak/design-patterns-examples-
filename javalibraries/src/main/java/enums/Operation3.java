package enums;

import java.util.function.IntBinaryOperator;

// Using designpatterns.gangoffour.strategy pattern with lambdas in enums
// Good for small operations
public enum Operation3 {
  ADD(Integer::sum),
  SUBTRACT((x, y) -> x - y),
  MULTIPLY(Multiply::apply); // Can extract big operations to other class and use method reference

  private final IntBinaryOperator operator;

  Operation3(final IntBinaryOperator operator) {
    this.operator = operator;
  }
}
