package refactoring.dry.example1._03allshareissues;

public class ClassA implements Service {

    private final SharedWorker sharedWorker;

    public ClassA(SharedWorker sharedWorker) {
        this.sharedWorker = sharedWorker;
    }

    @Override
    public void execute(String input) {
        String result = sharedWorker.execute(input);

        // store in database
        System.out.println(result);
    }

}
