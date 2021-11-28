package designpatterns.gangoffour.factory.abstractfactory.exampleone;

public class Snake implements Animal {

  @Override
  public String makeSound() {
    return "Hiss";
  }

}