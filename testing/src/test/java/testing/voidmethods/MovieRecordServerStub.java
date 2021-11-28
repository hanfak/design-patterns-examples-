package testing.voidmethods;

public class MovieRecordServerStub implements RecordServer {

    private double price;

    @Override
    public void addMovieOrder(String customerId, String filmName, double price) {
        this.price  = price;
    }

    public double getPrice() {
        return price;
    }
}
