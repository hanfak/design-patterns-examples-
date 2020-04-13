package javalibraries.enums;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Using designpatterns.gangoffour.strategy pattern with lambdas in enums
// Good for small operations
public enum Operation4 {
  ADD(Integer::sum, "a"),
  SUBTRACT((x, y) -> x - y, "b"),
  MULTIPLY(Multiply::apply, "c"); // Can extract big operations to other class and use method reference

  private final IntBinaryOperator operator;
  private final String key;

  Operation4(final IntBinaryOperator operator, String key) {
    this.operator = operator;
    this.key = key;
  }

  // Use enum for keys in a map, to create a map
  private static final Map<String, Operation4> VALUE_MAP = Stream.of(values())
          .collect(Collectors.toMap(Operation4::toKeyValue, o -> o));

  public String toKeyValue() {
    return key;
  }

  // Can user a getter to get value using key.
  // need optional to avoid no key in map
  public static Optional<Operation4> fromString(String key) {
    return Optional.ofNullable(VALUE_MAP.get(key));
  }
}
