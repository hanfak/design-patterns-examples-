package nullobject.exampletwo;

public class Rectangle implements Shape {
  private final double width;
  private final double length;

  public Rectangle() {
    this(1.0d, 1.0d);
  }

  public Rectangle(double width, double length) {
    this.width = width;
    this.length = length;
  }

  @Override
  public double area() {
    return width * length;
  }

  @Override
  public double perimeter() {
    return 2 * (width + length);
  }

  @Override
  public void draw() {
    System.out.println("Drawing Rectangle with area: " + area() + " and perimeter: " + perimeter());
  }

  @Override
  public boolean isNull() {
    return false;
  }
}
