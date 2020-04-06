package designpatterns.nullobject.examplethree;

import java.util.Arrays;
import java.util.Optional;

public class App {

  public static void main(String[] args) {
    String[] shapeTypes = new String[] { "Circle", null, "Triangle", "Pentagon", "Rectangle", "Trapezoid"};
    Arrays.asList(shapeTypes).forEach(shapeType -> {
      Optional<Shape> optionalShape = ShapeFactory.createShape(shapeType);
      optionalShape.ifPresent((shape) -> {
        // null-check is done by ifPresent of Optional
        System.out.println("Shape area: " + shape.area());
        System.out.println("Shape Perimeter: " + shape.perimeter());
        shape.draw();
        System.out.println();
      });
    });
  }
}
