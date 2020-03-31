package designpatterns.adapter.exampleone;

public class PlasticToyDuck implements ToyDuck {
  @Override
  public void squeak() {
    System.out.println("Squeak");
  }
}
