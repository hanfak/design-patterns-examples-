package factory.supplier.exampleone.old;

import factory.supplier.exampleone.AcmeSalesServer;
import factory.supplier.exampleone.Customer;
import factory.supplier.exampleone.Movie;
import factory.supplier.exampleone.SaleDetails;

public class SaleRecorder {

    /**
     The SaleRecorder has a method which has call to AcmeBillingServer to add the sale, this makes it hard to test,
     as AcmeBillingServer.connect() is connecting to an actual production sales server everytime the recordSale()
     method is called. Plus AcmeBillingServer.connect() is a static factory method, which news up an instance of
     AcmeBillingServer.

     This makes it hard to test,
        - as we cannot mock static methods,
        - we are not allowed to change the implementation of the constructor of SaleRecorder
            or AcmeSalesServer which reside in other classes,
        - We do not want to call recordSale in it's current state in a test as it will connect to
            a production code and possible makes changes
        = We do not want connect to AcmeSalesServer at the construction of the SaleRecorder object
            as this object lasts a long time (either the entire lifecycle of application of the app or
            during a very long batch operation which means the AcmeSalesServer might not have been updated
            and we need a current AcmeSalesServer when recordSale() is called.
            Plus we are changing the behaviour!
     */
    void recordSale(Customer customer, Movie movie, SaleDetails saleDetails) {
        System.out.println("Connecting to Sales server");
        AcmeSalesServer salesServer = AcmeSalesServer.connect();
        System.out.println("Adding sale to server");
        salesServer.addSale(customer, movie, saleDetails);
        System.out.println("Sale added");
    }
}
