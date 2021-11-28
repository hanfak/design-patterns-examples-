package designpatterns.consoleinterface.example1.commands;

// Like a servlet - as it deals with inputs and outputs
// Logic if any can be delegated to some dependency (usecase)
public class PostCommand implements Command {

  private static final String POST_COMMAND = " -> ";
  private final String userCommand;

  public PostCommand(String userCommand) {
    this.userCommand = userCommand;
  }

  @Override
  public void execute() {
    String[] userAndMessage = userCommand.split(POST_COMMAND);
    String user = userAndMessage[0];
    String message = userAndMessage[1];
    // Can delegate to some usecase which deals with business rules
  }
}
