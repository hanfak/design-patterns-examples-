package refactoring.nestedifs.example1.newversion;

public class Operation1 {
  private Checker checker;

  public Operation1(Checker checker) {
    this.checker = checker;
  }

  public String multipleOperations() {

    if (!checker.operation1()) {
      return "Failure 1";
    }

    if (!checker.operation2()) {
       return "Failure 2";
    }

    if (!checker.operation3()) {
       return "Failure 3";
    }

    if (!checker.operation4()) {
       return "Failure 4";
    }

    return "Passed";
  }
}
