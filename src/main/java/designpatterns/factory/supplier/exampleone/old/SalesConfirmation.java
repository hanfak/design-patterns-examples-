package designpatterns.factory.supplier.exampleone.old;

import designpatterns.factory.supplier.exampleone.Customer;
import designpatterns.factory.supplier.exampleone.Movie;
import designpatterns.factory.supplier.exampleone.SaleDetails;

/**
 * Cannot touch this class, might be in another library
 */
public class SalesConfirmation {
  public void finaliseSale(Customer customer, Movie movie, SaleDetails saleDetails) {
    System.out.println("Some other stuff");
    System.out.println("Call line below multiple times, ");
    new SaleRecorder().recordSale(customer, movie, saleDetails);
    System.out.println("Some more stuff");
  }
}
