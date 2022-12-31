package refactoring.dry.example1._02allshare;

public class SharedWorkerImpl implements SharedWorker {
    @Override
    public String execute(String input) {
        return input.toLowerCase();
    }
}