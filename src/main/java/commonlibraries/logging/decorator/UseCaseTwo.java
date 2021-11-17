package commonlibraries.logging.decorator;

import lombok.SneakyThrows;

public class UseCaseTwo implements UseCase<InstructionTwo>{
  @SneakyThrows
  @Override
  public void execute(InstructionTwo input) {
    if (input.getValue() == 1) {
      throw new IllegalStateException("Its bad " + input);
    }
    if (input.getValue() == 2) {
      throw new UseCaseExecption("its worse " + input);
    }
    if (input.getValue() == 3){
      throw new Exception("end of the world " + input);
      // could throw a Checked exception and change the method signature
      // But used sneaky throws
    }
    System.out.println(input.instructionValue());
  }
}
