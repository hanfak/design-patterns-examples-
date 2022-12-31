package refactoring.dry.example1._03_2allshareissues_fix;

// This can be used by A, but later can be used by other classes

public class AddedWorkToSharedWorkerImpl implements SharedWorker {
    private final SharedWorker delegate;

    public AddedWorkToSharedWorkerImpl(SharedWorker delegate) {
        this.delegate = delegate;
    }

    @Override
    public String execute(String input) {
        return delegate.execute(input).concat(" people");
    }
}