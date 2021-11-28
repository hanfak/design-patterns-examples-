package designpatterns.gangoffour.factory.abstractfactory.examplefour;

import static designpatterns.gangoffour.factory.abstractfactory.examplefour.FactoryType.THREE_D_SHAPE_FACTORY;
import static designpatterns.gangoffour.factory.abstractfactory.examplefour.FactoryType.TWO_D_SHAPE_FACTORY;
import static designpatterns.gangoffour.factory.abstractfactory.examplefour.ShapeType.CIRCLE;
import static designpatterns.gangoffour.factory.abstractfactory.examplefour.ShapeType.LINE;
import static designpatterns.gangoffour.factory.abstractfactory.examplefour.ShapeType.SPHERE;

public class App {
  public static void main(String[] args) {
    //drawing 2D shape
    AbstractFactory factory = FactoryProvider.getFactory(TWO_D_SHAPE_FACTORY);

    //getting shape using factory obtained
    GeometricShape shape = factory.getShape(LINE);
    shape.draw();

    shape = factory.getShape(CIRCLE);
    shape.draw();

    //drawing 3D shape
    factory = FactoryProvider.getFactory(THREE_D_SHAPE_FACTORY);

    //getting shape using factory obtained
    shape = factory.getShape(SPHERE);
    shape.draw();
  }
}
