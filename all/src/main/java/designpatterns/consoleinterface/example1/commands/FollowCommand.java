package designpatterns.consoleinterface.example1.commands;

// Like a servlet - as it deals with inputs and outputs
// Logic if any can be delegated to some dependency (usecase)
public class FollowCommand implements Command {

  private static final String FOLLOW_COMMAND = " follows ";

  private final String userCommand;

  public FollowCommand(String userCommand) {
    this.userCommand = userCommand;
  }

  @Override
  public void execute() {
    String[] userAndMessage = userCommand.split(FOLLOW_COMMAND);
    String follower = userAndMessage[0];
    String followee = userAndMessage[1];
    // Do something
    // Possibly have some return value
  }
}

