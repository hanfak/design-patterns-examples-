package consoleinterface.example1.commands;


import consoleinterface.example1.console.Console;
import consoleinterface.example1.domain.Post;

import java.time.LocalDateTime;
import java.util.List;

// Like a servlet - as it deals with inputs and outputs
// Logic if any can be delegated to some dependency (usecase)
public class ReadCommand implements Command {

  private final String userName;
  private final Console console;

  public ReadCommand(Console console, String userName) {
    this.console = console;
    this.userName = userName;
  }

  @Override
  public void execute() {
    // Can delegate to some usecase which deals with business rules

    // Can have some sort of serializer to return a formatted response, on the output, back to console
    List<Post> output = List.of(new Post("Blah", "Something to say", LocalDateTime.now()));
    console.write(output);
  }
}
