package refactoring.dry.example1._03allshareissues;

public class ClassD implements Service {

    private final SharedWorker sharedWorker;

    public ClassD(SharedWorker sharedWorker) {
        this.sharedWorker = sharedWorker;
    }

    @Override
    public void execute(String input) {
        String result = sharedWorker.execute(input);

        // print to log
        System.out.println(result);
    }

}
