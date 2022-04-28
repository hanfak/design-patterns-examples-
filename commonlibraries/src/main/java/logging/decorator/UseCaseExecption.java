package logging.decorator;

public class UseCaseExecption extends RuntimeException {
  public UseCaseExecption(String message) {
    super(message);
  }
}
