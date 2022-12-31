package refactoring.dry.example1._02allshare;

public class OtherSharedWorkerImpl implements SharedWorker {
    @Override
    public String execute(String input) {
        return input.toUpperCase();
    }
}