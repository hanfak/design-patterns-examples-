package enterprisepatterns.validationengine.version3;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

public class StringArgumentValidator implements Validator<String> {

  private final Predicate<String> rule1 = Objects::isNull;
  private final Predicate<String> rule2 = String::isBlank;
  private final Predicate<String> rule3 = input -> !input.contains("Hello");
  private final Predicate<String> rule4 = input -> !input.matches("^.*[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w].*$");

  @Override
  public String validate(String input) {
    Predicate<String> breakingValidationRules = rule1.or(rule2).or(rule3).or(rule4); // This can be as complex as you need
    return Optional.ofNullable(input)
        .filter(not(breakingValidationRules))
        .orElseThrow(() -> new IllegalArgumentException("Argument was not valid, actual argument was: " + input));
  }
}