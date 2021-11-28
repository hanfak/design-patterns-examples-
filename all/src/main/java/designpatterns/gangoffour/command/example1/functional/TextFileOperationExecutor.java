package designpatterns.gangoffour.command.example1.functional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * An invoker is an object that knows how to execute a given command but
 * doesn't know how the command has been implemented. It only knows the command's interface.
 *
 * Sometimes,  the invoker also stores and queues commands, aside from executing them.
 * This is useful for implementing some additional features, such as macro recording or undo and redo functionality.
 *
 * The TextFileOperationExecutor class is just a thin layer of abstraction that decouples the command objects from their consumers
 */
public class TextFileOperationExecutor {
  private final List<TextFileOperation> textFileOperations = new ArrayList<>();

  public String executeOperation(TextFileOperation textFileOperation) {
    textFileOperations.add(textFileOperation); // Not necessary but useful for other operations that might want to add
    return textFileOperation.execute();
  }

  public void executeAll() {
    textFileOperations.forEach(TextFileOperation::execute);
  }
}
