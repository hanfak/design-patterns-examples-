package refactoring.dry.example1._03_2allshareissues_fix;

// This can be used by either ABCD
public class OtherSharedWorkerImpl implements SharedWorker {
    @Override
    public String execute(String input) {
        return input.toUpperCase();
    }
}