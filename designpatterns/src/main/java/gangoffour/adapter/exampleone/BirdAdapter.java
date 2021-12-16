package gangoffour.adapter.exampleone;

public class BirdAdapter implements ToyDuck {

  private final Bird bird;

  public BirdAdapter(Bird bird) {
    // we need reference to the object we are adapting
    this.bird = bird;
  }

  @Override
  public void squeak() {
    bird.makeSound(); // translate the methods appropriately
  }
}
