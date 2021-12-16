package consoleinterface.example1.commands;

public class CommandExecutor {

  private final CommandFactory commandFactory;

  public CommandExecutor(CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  public void execute(String userCommand) {
    commandFactory.create(userCommand).execute();
  }
}
