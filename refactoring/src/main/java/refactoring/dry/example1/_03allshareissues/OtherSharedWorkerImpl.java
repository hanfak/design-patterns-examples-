package refactoring.dry.example1._03allshareissues;

public class OtherSharedWorkerImpl implements SharedWorker {
    @Override
    public String execute(String input) {
        return input.toUpperCase();
    }
}