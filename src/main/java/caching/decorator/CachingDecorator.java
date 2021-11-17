package caching.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.isNull;

// Removes the logging out of delegate, and this decorator can be used with other classes
public class CachingDecorator<T extends Instruction> implements UseCase<T> {
  // The type is generic but bounded by Instruction, this allows multiple types to be used
  // could practice to have only one arg, but can created decorators which take multiple args
  private final Logger logger = LoggerFactory.getLogger("Application logger");
  private final UseCase<T> delegate;
  // This is just in memory cached, but could be a delegate to a caching service, or database etc
  private static String cachedValue;

  public CachingDecorator(UseCase<T> delegate) {
    this.delegate = delegate;
  }

  @Override
  public String execute(T input) {
    try {
      if (isNull(cachedValue)) {
        cachedValue = delegate.execute(input);
        return cachedValue;
      }
      return cachedValue;
    } catch (Exception e) { // A catch all for all exceptions
      logger.error("BLAHBLAH " + e.getMessage(), e);
      throw new RuntimeException("Something broke");
    }
  }

  // If using some delegate this can be hidden in there, where some rule is applied
  // or a library will do this
  public void invalidateCache() {
    cachedValue = null;
  }
}
