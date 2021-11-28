package refactoring.caseswitchrefactor.example4.old;

import static refactoring.caseswitchrefactor.example4.Constants.BAR;
import static refactoring.caseswitchrefactor.example4.Constants.CHEESE;
import static refactoring.caseswitchrefactor.example4.Constants.FOO;

// This is similar to a switch with lots of cases,
// but with if we can add increasing complexity in the conditional/predicate
// This extra complexity can get out of hand and should be refactored
public class OldUseCase {
  public void execute(String input) {
    if (input.startsWith(FOO)) {
      method1();
    } else if (input.startsWith(BAR)) {
      method2();
    } else if (input.startsWith(CHEESE)) {
      method3();
    }
  }

  // These methods are void return types (command/sideeffects), but can be query methods too
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
