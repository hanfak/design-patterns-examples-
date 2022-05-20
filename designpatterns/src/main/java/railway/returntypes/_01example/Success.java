package railway.returntypes._01example;

public class Success extends Result {
    public final boolean isSuccess() {
        return true;
    }

    @Override
    public int hashCode() {
        return Success.class.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Success;
    }
}
