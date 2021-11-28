package architecturepatterns.mappings.version1;

import architecturepatterns.mappings.version1.dataprovider.Dataprovider;
import architecturepatterns.mappings.version1.entryprovider.Controller;
import architecturepatterns.mappings.version1.usecase.port.UseCaseImpl;

/**
 * Example of a full mapping designpatterns.gangoffour.strategy.
 *
 * When communicating between layers, the model used is specific to it's interface
 *
 * When communicating within it's layer, the model is only used within it's layer, where it grabs all
 * the state from the interface model and stores it in the layers model
*/
public class Main {
  public static void main(String... args) {
    Dataprovider dataprovider = new Dataprovider();
    Controller controller = new Controller(new UseCaseImpl(dataprovider, dataprovider));
    System.out.println(controller.handle("Hello"));
  }
}
