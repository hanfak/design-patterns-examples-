package designpatterns.gangoffour.command.example1.plain;

import designpatterns.gangoffour.command.example1.TextFile;

public class OpenTextFileOperation implements TextFileOperation {
  private final TextFile textFile;

  public OpenTextFileOperation(TextFile textFile) {
    this.textFile = textFile;
  }

  @Override
  public String execute() {
    return textFile.open();
  }
}

/**
 *
 * A command class
 *
 * A command is an object whose role is to store all the information required for executing an action,
 * including the method to call, the method arguments, and the object (known as the receiver) that implements the method.
 *
 */