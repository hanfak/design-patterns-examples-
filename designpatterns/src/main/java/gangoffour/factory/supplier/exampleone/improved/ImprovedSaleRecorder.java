package gangoffour.factory.supplier.exampleone.improved;

import gangoffour.factory.supplier.exampleone.*;

/**
 * Here we have made the class testable, so we can stub out the SalesServer, ie pass in a replacement
 * for AcmeSalesServer which has same  functionality but with simple or no implementation
 * and we can add more functionality to help with testing.
 * This is done using polymorphism and use of interfaces.
 *
 * It is testable, as we can inject the dependency SalesServer into ImprovedSaleRecorder. By passing in a stub
 * we avoid having to call the production salesServer. Thus isolating the testing to this class
 *
 * We have two constructors, one to keep the original behaviour, and the other with the dependency as a param
 * to allow us to test it.
 *
 * Problem with this is that the behaviour has changed!!! We are connecting to AcmeSalesServer only once at the
 * creation of the object, not everytime we call the method recordSale(). But this is a good first step
 *
 * As behaviour has changed, this is not a refactoring.
 *
 * Possible to check if instance is created everytime recordSale is called??
 */

public class ImprovedSaleRecorder {

  private final SalesServer salesServer;

  public ImprovedSaleRecorder() {
    this(AcmeSalesServer.connect());
  }

  public ImprovedSaleRecorder(SalesServer salesServer) {
    System.out.println("Connecting to Sales server");
    this.salesServer = salesServer;
  }

  void recordSale(Customer customer, Movie movie, SaleDetails saleDetails) {
    System.out.println("Adding sale to server");
    salesServer.addSale(customer, movie, saleDetails);
    System.out.println("Sale added");
  }
}
