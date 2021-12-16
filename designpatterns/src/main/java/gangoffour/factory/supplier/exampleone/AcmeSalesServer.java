package gangoffour.factory.supplier.exampleone;

import static java.lang.String.format;

/**
 * Cannot touch this class, might be in another library
 */
public class AcmeSalesServer implements SalesServer {
  public static AcmeSalesServer connect() {
    return new AcmeSalesServer();
  }

  @Override
  public void addSale(Customer customer, Movie movie, SaleDetails saleDetails) {
    // Could add to a database
    System.out.printf("Added sale %s of %s to  %s to Acme billing server%n", saleDetails, movie, customer);
  }
}
