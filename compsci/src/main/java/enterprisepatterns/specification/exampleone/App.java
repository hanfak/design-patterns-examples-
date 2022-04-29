package enterprisepatterns.specification.exampleone;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    State state = State.Ready;

    while (state != State.Exiting) {
      System.out.println(state.inputs);
      if (state.explicit) {
        System.out.print("> ");
        state = state.nextState(sc.nextLine().trim(), state);
      } else {
        state = state.nextState(state.inputs.get(0), state);
      }
    }
  }
}
