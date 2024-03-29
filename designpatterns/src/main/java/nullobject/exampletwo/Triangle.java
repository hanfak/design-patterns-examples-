package nullobject.exampletwo;

public class Triangle implements Shape {
  private final double a;
  private final double b;
  private final double c;

  public Triangle() {
    this(1.0d, 1.0d, 1.0d);
  }

  public Triangle(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public double area() {
    double s = (a + b + c) / 2;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  @Override
  public double perimeter() {
    return a + b + c;
  }

  @Override
  public void draw() {
    System.out.println("Drawing Triangle with area: " + area() + " and perimeter: " + perimeter());
  }

  @Override
  public boolean isNull() {
    return false;
  }
}