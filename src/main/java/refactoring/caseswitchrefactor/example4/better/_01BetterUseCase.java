package refactoring.caseswitchrefactor.example4.better;

import java.util.Map;

import static refactoring.caseswitchrefactor.example4.Constants.BAR;
import static refactoring.caseswitchrefactor.example4.Constants.CHEESE;
import static refactoring.caseswitchrefactor.example4.Constants.FOO;

public class _01BetterUseCase {
  private final Map<String, Runnable> MAPPING = Map.of(
      FOO, this::method1,
      BAR, this::method2,
      CHEESE, this::method3
      );
  public void execute(String input) {
    MAPPING
        .entrySet().stream()
        // keep the items that match the condition and drop every other
        .filter(e -> input.startsWith(e.getKey())) // Some rule, which could be abstracted
        // we had Map.Entry<String, Runnable>, but now we only need the value e.g. the Runnable
        .map(Map.Entry::getValue)
        // short circuit, e.g. we only want the first value that matches
        .findFirst()
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
