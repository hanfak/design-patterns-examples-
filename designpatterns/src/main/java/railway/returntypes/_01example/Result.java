package railway.returntypes._01example;

abstract class Result {
    @SuppressWarnings("WeakerAccess")
    public abstract boolean isSuccess();

    @SuppressWarnings("WeakerAccess")
    public final boolean isFailure() {
        return !isSuccess();
    }
}
