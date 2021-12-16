package gangoffour.adapter.exampleone;

public class Sparrow implements Bird {
  @Override
  public void fly() {
    System.out.println("Flying");
  }

  @Override
  public void makeSound() {
    System.out.println("Chirp Chirp");
  }
}
