package testing.systemout.example2;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServiceTest {
  @Test
  public void test() {
    Printer printer = mock(Printer.class);
    Service underTest = new Service(printer);

    underTest.doSomething("hello");

    verify(printer).print("hello");
  }
}