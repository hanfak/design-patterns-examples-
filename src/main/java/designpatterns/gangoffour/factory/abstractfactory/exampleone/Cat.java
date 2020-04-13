package designpatterns.gangoffour.factory.abstractfactory.exampleone;

public class Cat implements Animal {

  @Override
  public String makeSound() {
    return "Meow";
  }

}