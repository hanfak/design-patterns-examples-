package refactoring.dry.example1._03allshareissues;

public class ClassC implements Service {

    private final SharedWorker sharedWorker;

    public ClassC(SharedWorker sharedWorker) {
        this.sharedWorker = sharedWorker;
    }

    @Override
    public void execute(String input) {
        String result = sharedWorker.execute(input);

        // send message to queue
        System.out.println(result);
    }

}
