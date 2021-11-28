package testing.systemout.example1;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServiceTest {
  @Test
  public void test() {
    PrintStream printStream = mock(PrintStream.class);
    Service underTest = new Service(printStream);

    underTest.doSomething("hello");

    verify(printStream).println("hello");
  }
}