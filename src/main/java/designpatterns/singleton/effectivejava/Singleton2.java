package designpatterns.singleton.effectivejava;

// Better way of creating a singleton
public enum Singleton2 {
  INSTANCE(1, "Hello");

  private final int i;
  private final String hello;

  // Constructor is already private
  Singleton2(int i, String hello) {
    this.i = i;
    this.hello = hello;
  }
}
