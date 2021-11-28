package refactoring.caseswitchrefactor.example5.factory;

import java.util.Map;
import java.util.Optional;

public class OperatorFactory {
  private static final Map<String, Operation> operationMap = Map.of(
    "add", new Addition(),
    "multiply", new Multiplication()
    // more operators
  );

  public static Optional<Operation> getOperation(String operator) {
    return Optional.ofNullable(operationMap.get(operator));
  }
}
