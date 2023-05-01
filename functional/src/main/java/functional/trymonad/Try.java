package functional.trymonad;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Try<T> {

    private final T result;
    private final Exception exception;

    private Try(T result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }

    public static <T> Try<T> of(CheckedSupplier<T> supplier) {
        try {
            return new Try<>(supplier.get(), null);
        } catch (Exception ex) {
            return new Try<>(null, ex);
        }
    }

    public boolean isSuccess() {
        return exception == null;
    }

    public boolean isFailure() {
        return exception != null;
    }

    public T get() throws Exception {
        if (isFailure()) {
            throw exception;
        }
        return result;
    }

    public Try<T> onFailure(CheckedConsumer<Exception> consumer) throws Exception {
        if (isFailure()) {
            consumer.accept(exception);
        }
        return this;
    }


    public Try<T> onSuccess(CheckedConsumer<Exception> consumer) {
        if (isSuccess()) {
            try {
                consumer.accept(exception);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return this;
    }

    public T getOrElse(T defaultValue) {
        if (isSuccess()) {
            return result;
        } else {
            return defaultValue;
        }
    }

    public Optional<T> toOptional() {
        if (isSuccess()) {
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }

    public <U extends Throwable> Try<T> recover(Class<U> exceptionClass, Function<U, T> recoverFn) {
        if (isFailure() && exceptionClass.isInstance(exception)) {
            try {
                return new Try<>(recoverFn.apply(exceptionClass.cast(exception)), null);
            } catch (Exception ex) {
                return new Try<>(null, ex);
            }
        }

        return this;
    }

    public <R> Try<R> map(Function<T, R> mapper) {
        if (isSuccess()) {
            try {
                return new Try<>(mapper.apply(result), null);
            } catch (Exception ex) {
                return new Try<>(null, ex);
            }
        } else {
            return new Try<>(null, exception);
        }
    }

    public <R> Try<R> mapTry(Function<T, R> mapper) {
        if (isSuccess()) {
            try {
                return Try.of(() -> mapper.apply(result));
            } catch (Exception ex) {
                return new Try<>(null, ex);
            }
        } else {
            return new Try<>(null, exception);
        }
    }

    public Try<T> filter(Predicate<T> predicate) {
        if (isSuccess()) {
            if (predicate.test(result)) {
                return this;
            } else {
                return new Try<>(null, new NoSuchElementException("No value present"));
            }
        } else {
            return this;
        }
    }

    @FunctionalInterface
    public interface CheckedSupplier<T> {
        T get() throws Exception;
    }

    @FunctionalInterface
    public interface CheckedConsumer<T> {
        void accept(T t) throws Exception;
    }
}

