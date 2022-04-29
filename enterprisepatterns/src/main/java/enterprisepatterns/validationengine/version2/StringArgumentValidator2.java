package enterprisepatterns.validationengine.version2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Multiple validations with own specific exceptions on one input value
public class StringArgumentValidator2 implements Validator<String> {
  private final Supplier<IllegalStateException> exception1 = () -> new IllegalStateException("Should not be null");
  private final Supplier<IllegalArgumentException> exception2 = () -> new IllegalArgumentException("Should contain Hello");
  private final Supplier<NumberFormatException> exception3 = () -> new NumberFormatException("Should contain number");
  private final Predicate<String> subRule1 = Objects::isNull;
  private final Predicate<String> subRule2 = input -> !input.contains("Hello");
  private final Predicate<String> subRule3 = input -> !input.contains("3");
  private final Pair<Predicate<String>, Supplier<IllegalStateException>> validationRule1 = Pair.of(subRule1, exception1);
  private final Pair<Predicate<String>, Supplier<IllegalArgumentException>> validationRule2 = Pair.of(subRule2, exception2);
  private final Pair<Predicate<String>, Supplier<NumberFormatException>> validationRule3 = Pair.of(subRule3, exception3);

  @Override
  public String validate(String input) {
    // Or rule -> at least one rule fails
    // Cannot do and rule, as multiple rules must fail but can only throw one exception
    List<Pair<Predicate<String>, ? extends Supplier<? extends RuntimeException>>> rules =
        List.of(validationRule1, validationRule2, validationRule3);
    rules.stream()
        .filter(x -> x.getLeft().test(input))
        .map(Pair::getRight)
        .findAny()
        .ifPresent(this::throwException);
    return input;
  }

  private void throwException(Supplier<? extends RuntimeException> x) {
    throw x.get();
  }
}