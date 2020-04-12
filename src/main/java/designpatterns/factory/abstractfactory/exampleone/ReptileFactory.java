package designpatterns.factory.abstractfactory.exampleone;

public class ReptileFactory implements SpeciesFactory {

  @Override
  public Animal getAnimal(String type) {
    if ("snake".equals(type)) {
      return new Snake();
    } else {
      return new Tyrannosaurus();
    }
  }

}