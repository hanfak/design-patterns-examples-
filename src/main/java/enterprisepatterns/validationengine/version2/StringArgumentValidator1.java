package enterprisepatterns.validationengine.version2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
// For single or comles rule, Here we pass in arguments to exception message, generally the input. For one input value
public class StringArgumentValidator1 implements Validator<String> {
  private final Function<String, IllegalStateException> exception = x -> new IllegalStateException("Should contain Hello, actual: " + x);
  private final Predicate<String> subRule = Objects::isNull;
  private final Predicate<String> complexRule = subRule.or(input -> !input.contains("Hello"));
  private final Pair<Predicate<String>, Function<String, IllegalStateException>> validationRule1 = Pair.of(complexRule, exception);

  @Override
  public String validate(String input) {
    Optional.of(input)
        .filter(validationRule1.getLeft())
        .ifPresent(input1 -> throwException(validationRule1.getRight(), input1));
    return input;
// alt
//    if (validationRule1.getLeft().test(input)) {
//      throwException(validationRule1.getRight(), input);
//    }
//    return input;
  }

  private void throwException(Function<String, IllegalStateException> x, String input) {
    throw x.apply(input);
  }
}