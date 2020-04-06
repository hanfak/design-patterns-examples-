package designpatterns.nullobject.examplethree;

public class Circle implements Shape {
  private final double radius;

  public Circle() {
    this(1.0d);
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double area() {
    return Math.PI * Math.pow(radius, 2);
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public void draw() {
    System.out.println("Drawing Circle with area: " + area() + " and perimeter: " + perimeter());
  }

  @Override
  public boolean isNull() {
    return false;
  }
}