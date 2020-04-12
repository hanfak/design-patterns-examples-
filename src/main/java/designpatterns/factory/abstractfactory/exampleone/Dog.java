package designpatterns.factory.abstractfactory.exampleone;

public class Dog implements Animal {

  @Override
  public String makeSound() {
    return "Woof";
  }

}
