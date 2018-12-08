package testing.voidmethods;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class PricerTest implements WithAssertions {
    /**
     * Use of polymorphism and interfaces allows us to replace the dependency with a stubbed class
     * (seen below) which we can use to get the values. It is a stub and in test code, so we dont
     * care about extra methods
     *
     *
     * Can use mockito, mock the record server and verify the method was called
     * but we want to make sure the price was calculated correctly
     * Can do this directly in the enum, and verify the behaviour of the dependency was called
     * with correct args.
     */
    @Test
    public void newMoviePriceForOneOrder() {
        MovieRecordServerStub recordServer = new MovieRecordServerStub();
        Pricer pricer = new Pricer(recordServer);
        pricer.receiveOrderRecord("x123", "newMovie1", MovieType.NEW, 1);

        assertThat(recordServer.getPrice()).isEqualTo(5.0);
    }

    @Test
    public void childreMoviePriceForthreeOrders() {
        MovieRecordServerStub recordServer = new MovieRecordServerStub();
        Pricer pricer = new Pricer(recordServer);
        pricer.receiveOrderRecord("x123", "childrenMovie1", MovieType.CHILDREN, 3);

        assertThat(recordServer.getPrice()).isEqualTo(9.0);
    }
}

class MovieRecordServerStub implements RecordServer {

    private double price;

    @Override
    public void addMovieOrder(String customerId, String filmName, double price) {
        this.price  = price;
    }

    double getPrice() {
        return price;
    }
}