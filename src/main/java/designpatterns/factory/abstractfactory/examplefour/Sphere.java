package designpatterns.factory.abstractfactory.examplefour;

public class Sphere implements GeometricShape {
  @Override
  public void draw() {
    System.out.println("Sphere drawn.");
  }
}