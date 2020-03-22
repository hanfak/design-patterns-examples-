package refactoring.caseswitchrefactor.example1.old;

public class OldRunner {
    public static void main(String[] args) {
        PricerOld pricer = new PricerOld(new MovieRecordServer());
        pricer.receiveOrderRecord("123", "newMovie1", MovieTypeOld.NEW, 2);
        pricer.receiveOrderRecord("123", "childrenMovie1", MovieTypeOld.CHILDREN, 2);
        pricer.receiveOrderRecord("123", "specialMovie1", MovieTypeOld.SPECIAL, 2);


    }
}
