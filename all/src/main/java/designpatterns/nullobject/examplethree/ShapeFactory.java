package designpatterns.nullobject.examplethree;

import java.util.Optional;

public class ShapeFactory {
  public static Optional<Shape> createShape(String shapeType) {
    if ("Circle".equalsIgnoreCase(shapeType)) {
      return Optional.of(new Circle());
    } else if ("Rectangle".equalsIgnoreCase(shapeType)) {
      return Optional.of(new Rectangle());
    } else if ("Triangle".equalsIgnoreCase(shapeType)) {
      return Optional.of(new Triangle());
    } else {
      return Optional.empty();
    }
  }
}
