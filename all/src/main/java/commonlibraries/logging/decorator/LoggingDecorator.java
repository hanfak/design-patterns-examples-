package commonlibraries.logging.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Removes the logging out of delegate, and this decorator can be used with other classes
// Generally we log for exceptions, if logging general processes,
//      then this could be redundant as logging will be in delegate then
public class LoggingDecorator<T extends Instruction> implements UseCase<T>{
  // The type is generic but bounded by Instruction, this allows multiple types to be used
  // could practice to have only one arg, but can created decorators which take multiple args
  private final Logger logger = LoggerFactory.getLogger("Application logger");
  private final UseCase<T> delegate;

  public LoggingDecorator(UseCase<T> delegate) {
    this.delegate = delegate;
  }

  @Override
  public void execute(T input) {
    try {
      delegate.execute(input);
    } catch (IllegalStateException e) {
      logger.warn("blah " + e.getMessage(), e);
    } catch (UseCaseExecption e) {
      logger.error("blahblah " + e.getMessage(), e);
    } catch (Exception e) { // A catch all for all exceptions
      logger.error("BLAHBLAH " + e.getMessage(), e);
    }
  }

  // Can log, and then rethrow (maybe to be caught by an exception handler, in fact this is like an exception handler)
  // can also update database or do something else
}
