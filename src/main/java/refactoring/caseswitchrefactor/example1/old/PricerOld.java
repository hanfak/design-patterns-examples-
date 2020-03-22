package refactoring.caseswitchrefactor.example1.old;


import static java.lang.String.format;

class PricerOld {

    private final RecordServer recordServer;

    PricerOld(RecordServer recordServer) {
        this.recordServer = recordServer;
    }

    void receiveOrderRecord(String customerId, String filmName, MovieTypeOld movieType, int amountOrderd) {
        double price = 0;
        switch (movieType) {
            case NEW:
                price = 5 * amountOrderd;
                break;
            case CHILDREN:
                price = 3 * amountOrderd;
                break;
            case SPECIAL:
                price = 2 * amountOrderd;
                break;
        }

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