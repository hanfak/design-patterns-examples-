package designpatterns.factory.abstractfactory.examplefour;

public class Line implements GeometricShape {
  @Override
  public void draw() {
    System.out.println("Line Drawn.");
  }
}