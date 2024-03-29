package gangoffour.factory.abstractfactory.exampleone;

public class AbstractFactory {

  public SpeciesFactory getSpeciesFactory(String type) {
    if ("mammal".equals(type)) {
      return new MammalFactory();
    } else {
      return new ReptileFactory();
    }
  }

}
