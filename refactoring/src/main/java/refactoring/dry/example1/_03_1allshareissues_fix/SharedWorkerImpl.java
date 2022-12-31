package refactoring.dry.example1._03_1allshareissues_fix;

public class SharedWorkerImpl implements SharedWorker {
    @Override
    public String execute(String input) {
        // This can safely be used by B, C and D , as extra logic has been removed
        return input.toLowerCase();
    }
}