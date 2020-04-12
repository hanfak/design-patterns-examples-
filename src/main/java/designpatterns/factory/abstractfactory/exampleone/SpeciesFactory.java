package designpatterns.factory.abstractfactory.exampleone;

public interface SpeciesFactory {
  Animal getAnimal(String type);
}