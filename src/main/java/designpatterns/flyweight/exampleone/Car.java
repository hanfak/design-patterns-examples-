package designpatterns.flyweight.exampleone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Car implements Vehicle {
  private final static Logger LOG = LoggerFactory.getLogger(Car.class);

  private Engine engine;
  private Color color;

  public Car(Engine engine, Color color) {
    this.engine = engine;
    this.color = color;

    // Building a new car is a very expensive operation!
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      LOG.error("Error while creating a new car", e);
    }
  }

  @Override
  public void start() {
    LOG.info("Car is starting!");
    engine.start();
  }

  @Override
  public void stop() {
    LOG.info("Car is stopping!");
    engine.stop();
  }

  @Override
  public Color getColor() {
    return this.color;
  }

}
