package functional.functionalinterfaces.effectivejava;

@FunctionalInterface // This annotation allows compiler to stop you adding multiple methods
public interface MyFunction {
  // Functional interface should have only one method
   int apply(int x);
}
