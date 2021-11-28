package refactoring.caseswitchrefactor.example5.command;

public class Calculator {
  public int calculate(Command command) {
    return command.execute();
  }
}
