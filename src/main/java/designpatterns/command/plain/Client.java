package designpatterns.command.plain;

import designpatterns.command.TextFile;

/**
 *
 * controls the command execution process by specifying what commands to execute and
 * at what stages of the process to execute them.
 *
 */
public class Client {
  public static void main(String[] args) {
    TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

    textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt")));
    textFileOperationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt")));
  }
}
