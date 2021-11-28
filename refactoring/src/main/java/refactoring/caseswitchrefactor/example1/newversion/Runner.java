package refactoring.caseswitchrefactor.example1.newversion;

public class Runner {
    public static void main(String[] args) {
        Pricer pricer = new Pricer(new MovieRecordServer());
        pricer.receiveOrderRecord("x123", "newMovie1", MovieType.NEW, 2);
        pricer.receiveOrderRecord("x123", "childrenMovie1", MovieType.CHILDREN, 2);
        pricer.receiveOrderRecord("x123", "specialMovie1", MovieType.SPECIAL, 2);


    }
}
