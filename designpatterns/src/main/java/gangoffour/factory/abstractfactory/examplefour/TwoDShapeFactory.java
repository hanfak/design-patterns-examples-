package gangoffour.factory.abstractfactory.examplefour;

public class TwoDShapeFactory extends AbstractFactory {
  @Override
  GeometricShape getShape(ShapeType name) {
    if (ShapeType.LINE == name) {
      return new Line();
    } else if (ShapeType.CIRCLE == name) {
      return new Circle();
    }
    return null;
  }
}