package logging.decorator;

public class Runner {
  public static void main(String[] args) {
    LoggingDecorator<InstructionOne> loggingUseCaseOne = new LoggingDecorator<>(new UseCaseOne());
    LoggingDecorator<InstructionTwo> loggingUseCaseTwo = new LoggingDecorator<>(new UseCaseTwo());

    loggingUseCaseOne.execute(new InstructionOne("bad"));
    loggingUseCaseOne.execute(new InstructionOne("worse"));
    loggingUseCaseOne.execute(new InstructionOne("end of the world"));

    loggingUseCaseTwo.execute(new InstructionTwo(1));
    loggingUseCaseTwo.execute(new InstructionTwo(2));
    loggingUseCaseTwo.execute(new InstructionTwo(3));
  }
}
