package caching.decorator;

import lombok.SneakyThrows;

public class UseCaseOne implements UseCase<InstructionOne> {
  @SneakyThrows
  @Override
  public String execute(InstructionOne input) {
    if (input.getValue().equals("bad")) {
      throw new IllegalStateException("Its bad TOO");
    }
    if (input.getValue().equals("worse")) {
      throw new UseCaseExecption("its worse TOO");
    }
    if (input.getValue().equals("end of the world")){
      throw new RuntimeException("end of the world TOO");
    }
    Thread.sleep(3000);
    return input.instructionValue();
  }
}
