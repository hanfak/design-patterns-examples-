package designpatterns.gangoffour.flyweight.exampleone;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {

  /**
   * Stores the already created vehicles.
   */
  private static Map<Color, Vehicle> vehiclesCache = new HashMap<Color, Vehicle>();

  /**
   * Private constructor to prevent this class instantiation.
   */
  private VehicleFactory() {
  }

  /**
   * Returns a vehicle of the same color passed as argument. If that vehicle
   * was already created by this factory, that vehicle is returned, otherwise
   * a new one is created and returned.
   */
  public static Vehicle createVehicle(Color color) {
    // Looks for the requested vehicle into the cache.
    // If the vehicle doesn't exist, a new one is created.
    Vehicle newVehicle = vehiclesCache.computeIfAbsent(color, newColor -> {
      // Creates the new car.
      Engine newEngine = new Engine();
      return new Car(newEngine, newColor);
    });
    return newVehicle;
  }
}
