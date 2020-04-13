package designpatterns.gangoffour.factory.abstractfactory.exampleone;

public class MammalFactory implements SpeciesFactory {

  @Override
  public Animal getAnimal(String type) {
    if ("dog".equals(type)) {
      return new Dog();
    } else {
      return new Cat();
    }
  }

}