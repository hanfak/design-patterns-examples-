package refactoring.caseswitchrefactor.example4.better;

import java.util.Map;
import java.util.function.Predicate;

import static refactoring.caseswitchrefactor.example4.Constants.BAR;
import static refactoring.caseswitchrefactor.example4.Constants.CHEESE;
import static refactoring.caseswitchrefactor.example4.Constants.FOO;

public class _02BetterUseCase {

  private final Map<Predicate<String>, Runnable> MAPPING = Map.of(
      input -> input.startsWith(FOO), this::method1,
      input -> input.startsWith(BAR), this::method2,
      input -> input.startsWith(CHEESE), this::method3
  );

  public void execute(String input) {
    MAPPING.entrySet()
        .stream()
        .filter(entry -> entry.getKey().test(input))
        .findFirst()
        .map(Map.Entry::getValue)
        .ifPresent(Runnable::run);
  }

  private void method3() {
    System.out.println("does something because of CHEESE");
  }

  private void method2() {
    System.out.println("does something because of BAR");
  }

  private void method1() {
    System.out.println("does something because of FOO");
  }
}
