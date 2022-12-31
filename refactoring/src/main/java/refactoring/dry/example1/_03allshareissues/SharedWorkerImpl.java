package refactoring.dry.example1._03allshareissues;

public class SharedWorkerImpl implements SharedWorker {
    @Override
    public String execute(String input) {
        // This is only needed for class A, but B, C and D will hav to use this
        return input.toLowerCase().concat(" people");
    }
}