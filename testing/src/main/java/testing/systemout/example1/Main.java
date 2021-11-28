package testing.systemout.example1;

import java.io.PrintStream;

public class Main {
  public static void main(String... args) {
    PrintStream printStream = System.out;
    new Service(printStream).doSomething("hello");
  }
}
