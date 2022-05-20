package railway.returntypes._01example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("WeakerAccess")
public class UseCaseResult<FAILURE, SUCCESS> extends Result {
    public static <FAILURE, SUCCESS> UseCaseResult<FAILURE, SUCCESS> success(SUCCESS success) {
        return new UseCaseResult<>(null, success, true);
    }

    public static <FAILURE, SUCCESS> UseCaseResult<FAILURE, SUCCESS> failure(FAILURE failure) {
        return new UseCaseResult<>(failure, null, false);
    }

    private final FAILURE failure;
    private final SUCCESS success;
    private final boolean isSuccess;

    private UseCaseResult(FAILURE failure, SUCCESS success, boolean isSuccess) {
        this.failure = failure;
        this.success = success;
        this.isSuccess = isSuccess;
    }

    @Override
    public boolean isSuccess() {
        return isSuccess;
    }

    public SUCCESS success() {
        if (isSuccess()) {
            return success;
        }

        throw new ResultOperationException("Cannot return success from a failure result");
    }

    public FAILURE failure() {
        if (isFailure()) {
            return failure;
        }

        throw new ResultOperationException("Cannot return failure from a success result");
    }

    //Provides success or failure paths with return values
    public <T> OrElse<SUCCESS, FAILURE, T> ifSuccessful(Function<SUCCESS, T> ifSuccessful) {
        return new OrElse<>(ifSuccessful, this);
    }

    //Provides success or failure paths with no return value
    public OrElseDo<SUCCESS, FAILURE> ifSuccessfulDo(Consumer<SUCCESS> ifSuccessful) {
        return new OrElseDo<>(ifSuccessful, this);
    }

    //Success-only path with return value
    public <T> T onSuccess(Function<SUCCESS, T> onSuccess) {
        return this.isSuccess() ? onSuccess.apply(this.success()) : null;
    }

    //Failure-only path with return value
    public <T> T onFailure(Function<FAILURE, T> onFailure) {
        return this.isFailure() ? onFailure.apply(this.failure()) : null;
    }

    //Success-only path with no return value
    public void onSuccessDo(Consumer<SUCCESS> onSuccess) {
        if (this.isSuccess()) {
            onSuccess.accept(this.success());
        }
    }

    //Failure-only path with no return value
    public void onFailureDo(Consumer<FAILURE> onFailure) {
        if (this.isFailure()) {
            onFailure.accept(this.failure());
        }
    }

    public void onFailureThrow(Supplier<? extends RuntimeException> exception) {
        onFailureDo(failure -> {
            throw exception.get();
        });
    }

    @SuppressWarnings("SameParameterValue")
    public interface WithSuccessDetailsOnly {
        static <SUCCESS> UseCaseResult<Failure, SUCCESS> success(SUCCESS success) {
            return UseCaseResult.success(success);
        }

        static <SUCCESS> UseCaseResult<Failure, SUCCESS> failure() {
            return UseCaseResult.failure(new Failure());
        }
    }


    @SuppressWarnings("SameParameterValue")
    public interface WithFailureDetailsOnly {
        static <FAILURE> UseCaseResult<FAILURE, Success> success() {
            return UseCaseResult.success(new Success());
        }

        static <FAILURE> UseCaseResult<FAILURE, Success> failure(FAILURE failure) {
            return UseCaseResult.failure(failure);
        }
    }

    public interface WithNoDetails {
        static UseCaseResult<Failure, Success> success() {
            return UseCaseResult.success(new Success());
        }

        static UseCaseResult<Failure, Success> failure() {
            return UseCaseResult.failure(new Failure());
        }
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UseCaseResult<?, ?> that = (UseCaseResult<?, ?>) o;

        if (isSuccess != that.isSuccess) return false;
        if (failure != null ? !failure.equals(that.failure) : that.failure != null) return false;
        return success != null ? success.equals(that.success) : that.success == null;

    }

    @Override
    public int hashCode() {
        int result = failure != null ? failure.hashCode() : 0;
        result = 31 * result + (success != null ? success.hashCode() : 0);
        result = 31 * result + (isSuccess ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UseCaseResultResult{" +
                "failure=" + failure +
                ", success=" + success +
                ", isSuccess=" + isSuccess +
                '}';
    }

    public static class OrElse<SUCCESS, FAILURE, T> {
        private final Function<SUCCESS, T> ifSuccessful;
        private final UseCaseResult<FAILURE, SUCCESS> useCaseResult;

        public OrElse(Function<SUCCESS, T> ifSuccessful, UseCaseResult<FAILURE, SUCCESS> useCaseResult) {
            this.ifSuccessful = ifSuccessful;
            this.useCaseResult = useCaseResult;
        }

        public T orElse(Function<FAILURE, T> ifFailure) {
            if (useCaseResult.isSuccess()) {
                return ifSuccessful.apply(useCaseResult.success());
            }

            return ifFailure.apply(useCaseResult.failure());
        }

        public T orElseThrow(Supplier<? extends RuntimeException> exception) {
            return orElse(failure -> {
                throw exception.get();
            });
        }
    }

    public static class OrElseDo<SUCCESS, FAILURE> {
        private final Consumer<SUCCESS> ifSuccessful;
        private final UseCaseResult<FAILURE, SUCCESS> useCaseResult;

        public OrElseDo(Consumer<SUCCESS> ifSuccessful, UseCaseResult<FAILURE, SUCCESS> useCaseResult) {
            this.ifSuccessful = ifSuccessful;
            this.useCaseResult = useCaseResult;
        }

        public void orElseDo(Consumer<FAILURE> ifFailure) {
            if (useCaseResult.isSuccess()) {
                ifSuccessful.accept(useCaseResult.success());
            } else {
                ifFailure.accept(useCaseResult.failure());
            }
        }

        public void orElseDoThrow(Supplier<? extends RuntimeException> exception) {
            orElseDo(failure -> {
                throw exception.get();
            });
        }
    }
}
