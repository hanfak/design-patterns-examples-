package consoleinterface.example1.commands;


import consoleinterface.example1.console.Console;

import static java.util.regex.Pattern.matches;

public class CommandFactory {

  private final Console console;

  private static final String POST_COMMAND_PATTERN = "(.*)\\s->\\s(.*)";
  private static final String FOLLOW_COMMAND_PATTERN = "(.*)\\sfollows\\s(.*)";
  private static final String WALL_COMMAND_PATTERN = "(.*)\\swall";

  public CommandFactory(Console console) {
    this.console = console;
  }

  public Command create(String userCommand) {
    if (matches(POST_COMMAND_PATTERN, userCommand)) {
      // Can have some validation here of userCommand
      return new PostCommand(userCommand);
    } else if (matches(FOLLOW_COMMAND_PATTERN, userCommand)) {
      // Can have some validation here of userCommand
      return new FollowCommand(userCommand);
    } else if (matches(WALL_COMMAND_PATTERN, userCommand)) {
      // Can have some validation here of userCommand
      return new WallCommand(console, userCommand);
    } else {
      // Can have some validation here of userCommand
      return new ReadCommand(console, userCommand);
    }
  }
}

