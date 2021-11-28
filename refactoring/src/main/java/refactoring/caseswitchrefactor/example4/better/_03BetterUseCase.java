package refactoring.caseswitchrefactor.example4.better;

import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static refactoring.caseswitchrefactor.example4.Constants.BAR;
import static refactoring.caseswitchrefactor.example4.Constants.CHEESE;
import static refactoring.caseswitchrefactor.example4.Constants.FOO;

public class _03BetterUseCase {
  // depending on the method, it can be a supplier, or a type of function (Depending on inputs)
  private final Map<Predicate<String>, Supplier<String>> MAPPING = Map.of(
      input -> input.startsWith(FOO), this::method1,
      input -> input.startsWith(BAR), this::method2,
      input -> input.startsWith(CHEESE), this::method3
  );

  public void execute(String input) {
    String s = MAPPING.entrySet()
        .stream()
        .filter(entry -> entry.getKey().test(input))
        .findFirst()
        .map(entry -> entry.getValue().get())
        .orElseGet(() -> "default");
    System.out.println("s = " + s);
  }

  private String method3() {
    return "does something because of CHEESE";
  }

  private String method2() {
    return "does something because of BAR";
  }

  private String method1() {
    return "does something because of FOO";
  }
}
