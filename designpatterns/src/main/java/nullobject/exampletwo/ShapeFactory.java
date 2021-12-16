package nullobject.exampletwo;

public class ShapeFactory {
  public static Shape createShape(String shapeType) {
    if ("Circle".equalsIgnoreCase(shapeType)) {
      return new Circle();
    } else if ("Rectangle".equalsIgnoreCase(shapeType)) {
      return new Rectangle();
    } else if ("Triangle".equalsIgnoreCase(shapeType)) {
      return new Triangle();
    } else {
      return new NullShape();
    }
  }
}
