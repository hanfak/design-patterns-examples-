package refactoring.dry.example1._03_1allshareissues_fix;

public class OtherSharedWorkerImpl implements SharedWorker {
    @Override
    public String execute(String input) {
        return input.toUpperCase();
    }
}