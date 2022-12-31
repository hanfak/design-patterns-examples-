package refactoring.dry.example1._03allshareissues;

public class ClassB implements Service {
    private final SharedWorker sharedWorker;

    public ClassB(SharedWorker sharedWorker) {
        this.sharedWorker = sharedWorker;
    }
    @Override
    public void execute(String input) {
        String result = sharedWorker.execute(input);

        // send request to http server
        System.out.println(result);
    }

}
