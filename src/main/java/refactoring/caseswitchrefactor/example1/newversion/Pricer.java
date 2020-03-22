package refactoring.caseswitchrefactor.example1.newversion;


import static java.lang.String.format;

public class Pricer {

    private final RecordServer recordServer;

    Pricer(RecordServer recordServer) {
        this.recordServer = recordServer;
    }

    void receiveOrderRecord(String customerId, String filmName, MovieType movieType, int amountOrderd) {
        double price = movieType.calculateTotal(amountOrderd);
        recordServer.addMovieOrder(customerId, filmName, price);
    }
}

interface RecordServer {
    void addMovieOrder(String customerId, String filmName, double price);
}

class MovieRecordServer implements RecordServer {
    public void addMovieOrder(String customerId, String filmName, double price) {
        System.out.println(format("Customer '%s' ordered film '%s' at a price of '%s' hass been stored",
                customerId,filmName,price));
    }
}