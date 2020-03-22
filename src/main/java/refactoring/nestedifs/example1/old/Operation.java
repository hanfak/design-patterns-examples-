package refactoring.nestedifs.example1.old;


public class Operation {
  private Checker checker;

  public Operation(Checker checker) {
    this.checker = checker;
  }

  public String multipleOperations() {
    String error = "Fail";

    if (checker.operation1()) {
      if (checker.operation2()) {
        if (checker.operation3()) {
          if (checker.operation4()) {
          } else {
            error = "Failure 4";
          }
        } else {
          error = "Failure 3";
        }
      } else {
        error = "Failure 2";
      }
    } else {
      error = "Failure 1";
    }

    return error;
  }
}
