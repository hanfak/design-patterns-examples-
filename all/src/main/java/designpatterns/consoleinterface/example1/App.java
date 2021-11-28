package designpatterns.consoleinterface.example1;

import designpatterns.consoleinterface.example1.commands.CommandExecutor;
import designpatterns.consoleinterface.example1.commands.CommandFactory;
import designpatterns.consoleinterface.example1.console.Console;

public class App {

  private static final String EXIT = "exit";
  private final Console console;
  private final CommandExecutor commandExecutor;

  public App(Console console, CommandExecutor commandExecutor) {
    this.console = console;
    this.commandExecutor = commandExecutor;
  }

  public static void main(String... args) {
    wiring().start();
  }

  private static App wiring() {
    return new App(new Console(), new CommandExecutor(new CommandFactory(new Console())));
  }

  private void start() {
    String userCommand = console.readline();
    while(!EXIT.equals(userCommand)) {
      commandExecutor.execute(userCommand);
      userCommand = console.readline();
    }
    console.write("bye!");
  }
}
