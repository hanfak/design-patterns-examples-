package testing.voidmethods;

import static java.lang.String.format;

public class MovieRecordServer implements RecordServer {
    public void addMovieOrder(String customerId, String filmName, double price) {
        System.out.println(format("Customer '%s' ordered film '%s' at a price of '%s' hass been stored",
                customerId,filmName,price));
    }
}
