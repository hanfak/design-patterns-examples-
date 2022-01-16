package version1;


import version1.dataprovider.DataProvider;
import version1.entryprovider.Controller;
import version1.usecase.port.UseCaseImpl;
import version1.usecase.port.out.LoadDetails;
import version1.usecase.port.out.WriteDetails;

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
    // This is the wiring/configuration where the object graph is created
    LoadDetails loadDetails = new DataProvider();
    WriteDetails writeDetails = new DataProvider();
    Controller controller = new Controller(new UseCaseImpl(loadDetails, writeDetails));

    System.out.println(controller.handle("Hello"));
  }
}
