package logging.decorator;

public class UseCaseOne implements UseCase<InstructionOne>{
  @Override
  public void execute(InstructionOne input) {
    if (input.getValue().equals("bad")) {
      throw new IllegalStateException("Its bad TOO");
    }
    if (input.getValue().equals("worse")) {
      throw new UseCaseExecption("its worse TOO");
    }
    if (input.getValue().equals("end of the world")){
      throw new RuntimeException("end of the world TOO");
    }
    System.out.println(input.instructionValue());
  }
}
