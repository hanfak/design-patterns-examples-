package gangoffour.factory.supplier.exampleone.better;

import gangoffour.factory.supplier.exampleone.*;

import java.util.function.Supplier;

/**
 * Here we have used the implementation from ImprovedSaleRecorder class and changed it so it maintains the
 * original behaviour of the SaleRecorder class, thus this becomes a refactoring as behaviour has not changed but
 * code has.
 *
 * The use of this class in other classes has not changed.
 *
 * We use the Supplier Pattern. It is a slight change in how we store the dependency. We pass the dependency
 * into a lambda which is stored in the field salesServer. The salesServer is used in recordSale, and the
 * Supplier interface method, get(), is called on salesServer. This will then run the lambda and return the output
 * in this case get the instance.
 * Hence we are able to delay the instantation of the object, which implements SalesServer, in the recordSale
 * rather than in the construction. This is a form of lazy evaluation.
 *
 * This is also a form of a designpatterns.gangoffour.factory
 */

public class BetterSaleRecorder {

  private final Supplier<SalesServer> salesServer;

  public BetterSaleRecorder(SalesServer salesServer) {
    this.salesServer = () -> salesServer;
  }

  @SuppressWarnings("Convert2MethodRef")
  public BetterSaleRecorder() {
    this.salesServer = () -> AcmeSalesServer.connect();
  }

/**
 * This is just the java 7 implementation
 * public BetterSaleRecorder() {
      this.salesServer = new Supplier<SalesServer>() {
        @Override
        public SalesServer get() {
          return AcmeSalesServer.connect();
        }
      };
  }*/

  void recordSale(Customer customer, Movie movie, SaleDetails saleDetails) {
    System.out.println("Adding sale to server");
    salesServer.get().addSale(customer, movie, saleDetails);
    System.out.println("Sale added");
  }
}
