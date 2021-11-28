package testing.voidmethods;


import static java.lang.String.format;

public class Pricer {

    private final RecordServer recordServer;

    public Pricer(RecordServer recordServer) {
        this.recordServer = recordServer;
    }

    public void receiveOrderRecord(String customerId, String filmName, MovieType movieType, int amountOrderd) {
        double price = movieType.calculateTotal(amountOrderd);
        recordServer.addMovieOrder(customerId, filmName, price);
    }
}

