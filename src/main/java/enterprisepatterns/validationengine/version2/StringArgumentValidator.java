package enterprisepatterns.validationengine.version2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.function.Predicate.not;

// If complex/simple rule fails then general exception fails
public class StringArgumentValidator implements Validator<String> {
  private final Supplier<IllegalStateException> exception = () -> new IllegalStateException("Should contain Hello");
  // Different validation checks
  private final Predicate<String> subRule = input -> !input.contains("1");
  private final Predicate<String> complexRule = subRule.and(input -> !input.contains("Hello")); // and -> all should fail
  private final Predicate<String> complexRule1 = subRule.or(input -> !input.contains("Hello")); // or -> only one should fail
  private final Pair<Predicate<String>, Supplier<IllegalStateException>> validationRule1 = Pair.of(complexRule, exception);

  @Override
  public String validate(String input) {
    return Optional.of(input)
        .filter(not(validationRule1.getLeft()))
        .orElseThrow(validationRule1.getRight());
    // Compared to version1, we have specific exception thrown for a single/complex rule

  }
}