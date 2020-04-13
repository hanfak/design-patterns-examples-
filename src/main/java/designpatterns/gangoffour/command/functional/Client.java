package designpatterns.gangoffour.command.functional;

import designpatterns.gangoffour.command.TextFile;

/**
 *
 * controls the command execution process by specifying what commands to execute and
 * at what stages of the process to execute them.
 *
 */
public class Client {
  public static void main(String[] args) {
    // Example 1 - using lambdas
    TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

    textFileOperationExecutor.executeOperation(() -> "Opening file file1.txt");
    textFileOperationExecutor.executeOperation(() -> "Saving file file1.txt");

    // Example 2 - using method references
    TextFileOperationExecutor textFileOperationExecutor1 = new TextFileOperationExecutor();
    TextFile textFile = new TextFile("file1.txt");
    textFileOperationExecutor1.executeOperation(textFile::open);
    textFileOperationExecutor1.executeOperation(textFile::save);
  }
}
