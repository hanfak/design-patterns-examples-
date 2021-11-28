package testing.testharness;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class CustomAssertions {
  static class TestException extends RuntimeException {
    TestException(String message){
      super(message);
    }
  }

  public <T> void verify(Supplier<T> result, Predicate<T> verification) {
    verify(result, verification, "Test failed");
  }

  public <T> void verify(Supplier<T> result, Predicate<T> verification, String message) {
    if(verification.negate().test(result.get())) {
      throw new TestException(message);
    }
  }

  public void verifyException(Supplier<?> result, Predicate<Exception> verification) {
    verifyException(result, verification, "Expected exception not thrown");
  }

  public void verifyException(Supplier<?> result, Predicate<Exception> verification, String message) {
    try{
      result.get();
      throw new TestException(message);
    }catch(Exception e) {
      verify(() -> e, verification, message);
    }
  }
}
