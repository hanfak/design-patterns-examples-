package gangoffour.flyweight.exampleone;

import java.awt.*;

public class App {
  public static void main(String... args) {
    Vehicle vehicle = VehicleFactory.createVehicle(Color.BLACK);
    vehicle.getColor();
    vehicle.start();
    vehicle.stop();
    Vehicle vehicle1 = VehicleFactory.createVehicle(Color.BLACK);
    Vehicle vehicle2 = VehicleFactory.createVehicle(Color.RED);
    System.out.println(vehicle.equals(vehicle1));
    System.out.println(vehicle.equals(vehicle2));
  }
}
