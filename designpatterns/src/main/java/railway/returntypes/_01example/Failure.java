package railway.returntypes._01example;

public class Failure extends Result {
    public final boolean isSuccess() {
        return false;
    }


    @Override
    public int hashCode() {
        return Failure.class.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Failure;
    }
}
