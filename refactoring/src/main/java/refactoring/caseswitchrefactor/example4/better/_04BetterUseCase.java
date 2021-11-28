package refactoring.caseswitchrefactor.example4.better;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static refactoring.caseswitchrefactor.example4.Constants.BAR;
import static refactoring.caseswitchrefactor.example4.Constants.CHEESE;
import static refactoring.caseswitchrefactor.example4.Constants.FOO;

public class _04BetterUseCase {
  // methods are now separated into classes, so can be tested independently
  // can go further and extract the map as a delegate, esp if grows to big
  private final Map<Predicate<String>, Consumer<String>> MAPPING = Map.of(
      // The consumer could be query instead of command function
      input -> input.startsWith(FOO), new Action1(),
      input -> input.startsWith(BAR), new Action2(),
      input -> input.startsWith(CHEESE), new Action3()
  );

  public void execute(String input) {
    MAPPING.entrySet()
        .stream()
        .filter(entry -> entry.getKey().test(input))
        .findFirst()
        .map(Map.Entry::getValue)
        .ifPresent(x -> x.accept(input));

    // Another way, but this may produce zero, one or many depending on filter,
    // so need to make sure predicates, dont intersect (ie 2 or more predicateds return true for same input)
    MAPPING.entrySet()
        .stream()
        .filter(entry -> entry.getKey().test(input))
        .forEach(entry -> entry.getValue().accept(input));
  }
}
