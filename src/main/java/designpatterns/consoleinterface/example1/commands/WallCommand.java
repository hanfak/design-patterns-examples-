package designpatterns.consoleinterface.example1.commands;

import designpatterns.consoleinterface.example1.console.Console;

// Like a servlet - as it deals with inputs and outputs
// Logic if any can be delegated to some dependency (usecase)
public class WallCommand implements Command {

  private static final String WALL_COMMAND = " wall";

  private final String userCommand;
  private final Console console;

  public WallCommand(Console console,
                     String userCommand) {
    this.console = console;
    this.userCommand = userCommand;
  }

  @Override
  public void execute() {
    // Deserialiser
    String userName = userCommand.replaceAll(WALL_COMMAND, "");

    // Some rules that are delegated

    // serializer
    String output = "Something";

    console.write(output);
  }
}
