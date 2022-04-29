package enterprisepatterns.validationengine.version2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//Multiple validations with own specific message on one input value, throws a runtime exception, with multiple messages for each rule that failed
public class StringArgumentValidator4 implements Validator<String> {
  private final Supplier<IllegalStateException> exception1 = () -> new IllegalStateException("Should not be null");
  private final Supplier<IllegalArgumentException> exception2 = () -> new IllegalArgumentException("Should contain Hello");
  private final Supplier<NumberFormatException> exception3 = () -> new NumberFormatException("Should contain number");
  private final Predicate<String> subRule1 = Objects::isNull;
  private final Predicate<String> subRule2 = input -> !input.contains("Hello");
  private final Predicate<String> subRule3 = input -> !input.contains("3");
  private final Pair<Predicate<String>, String> validationRule1 = Pair.of(subRule1,"is null");
  private final Pair<Predicate<String>, String> validationRule2 = Pair.of(subRule2,"is not Hello");
  private final Pair<Predicate<String>, String> validationRule3 = Pair.of(subRule3,"no number:");

  @Override
  public String validate(String input) {
    // or rule -> specific rules fails, get message and throw in an exception
    List<Pair<Predicate<String>, String>> rules =
        List.of(validationRule1, validationRule2, validationRule3);
    String exceptionMessages = rules.stream()
        .filter(x -> x.getLeft().test(input))
        .map(Pair::getRight)
        .collect(Collectors.joining(", \n\n"));
    if (!exceptionMessages.isBlank()) {
      throw new RuntimeException(exceptionMessages +" : " + input);
    }

    return input;
  }

  private void throwException(Supplier<? extends RuntimeException> x) {
    throw x.get();
  }
}