package refactoring.caseswitchrefactor.example4.better;

import java.util.function.Consumer;

public class Action3 implements Consumer<String> {
  public void  accept(String input) {
    System.out.println("does something because of CHEESE for " + input);
  }
}
