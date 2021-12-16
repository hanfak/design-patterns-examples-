package gangoffour.template.exampleone.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//The ComputerBuilder class is responsible for outlining the steps required to build a computer
// by declaring methods for adding and setting up different components
public abstract class ComputerBuilder {
  protected final Map<String, String> computerParts = new HashMap<>();
  protected final List<String> motherboardSetupStatus = new ArrayList<>();

  //the build() method is the template method,
  // which defines steps of the algorithm for assembling the computer parts
  // and returns fully-initialized Computer instances.
  public final Computer buildComputer() { // Always final, so not to be overriden
    addMotherboard();
    setupMotherboard();
    addProcessor();
    return getComputer();
  }

  public abstract void addMotherboard();

  public abstract void setupMotherboard();

  public abstract void addProcessor();

  private Computer getComputer() {
    return new Computer(computerParts);
  }
}
