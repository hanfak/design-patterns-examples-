package enterprisepatterns.validationengine.version3;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

public class StringArgumentValidator implements Validator<String> {

  private final Predicate<String> rule1 = Objects::isNull;
  private final Predicate<String> rule2 = String::isBlank;
  private final Predicate<String> rule3 = input -> !input.contains("Hello");
  private final Predicate<String> rule4 = input -> !input.matches("^.*[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w].*$");

  @Override
  public List<String> validate(List<String> inputs) {
    Predicate<String> breakingValidationRules = rule1.or(rule2).or(rule3).or(rule4); // This can be as complex as you need
    return inputs.stream()
        .map(Optional::ofNullable)
        .map(input -> input
            .filter(not(breakingValidationRules))
            .orElseThrow(() -> new IllegalArgumentException("One of the elements was not valid, actual argument was: " + input)))
        .collect(toList());
  }
}