package functional.functionalinterfaces.effectivejava.strategy;

// How designpatterns.template pattern is implemented, outdated, better to use composition and designpatterns.strategy pattern
public abstract class TemplateBusinessLogic {
  public void compute() {
    System.out.println("x");
    System.out.println("y");
    System.out.println("z");
    doSomething();
    System.out.println("a");
    System.out.println("b");
    System.out.println("c");
  }

  protected abstract void doSomething();
}

class BusinessLogic extends TemplateBusinessLogic {

  @Override
  protected void doSomething() {
    System.out.println("Lots of things ");
  }

  public static void main(String... args) {
    new BusinessLogic().compute();
  }
}
