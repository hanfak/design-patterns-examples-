package functionalclean.better;

import java.util.function.Function;

public sealed interface Result<L, R> permits Result.Success, Result.Failure {

    final class Success<L, R> implements Result<L, R> {

        private final R value;

        public Success(R value) {
            this.value = value;
        }

        private R getValue() {
            return value;
        }
    }

    final class Failure<L, R> implements Result<L, R> {

        private final L value;

        public Failure(L value) {
            this.value = value;
        }

        private L getValue() {
            return value;
        }
    }

    static <L, R> Success<L, R> success(R value) {
        return new Success<>(value);
    }

    static <L, R> Failure<L, R> failure(L value) {
        return new Failure<>(value);
    }

    default <S> Result<L, S> bind(Function<R, S> bindedFunction) {
        if (success()) {
            return Result.success(bindedFunction.apply(getSuccess()));
        } else {
            return Result.failure(getFailure());
        }
    }

    default <M, N> Result<M, N> map(Function<L, M> failureMapper, Function<R, N> succssMapper) {
        if (success()) {
            return Result.success(succssMapper.apply(getSuccess()));
        } else {
            return Result.failure(failureMapper.apply(getFailure()));
        }
    }

    default R getSuccess() {

        throw new IllegalStateException();
    }

    default L getFailure() {
        throw new IllegalStateException();
    }

    default boolean success() {
        return false;
    }

    default boolean failure() {
        return false;
    }
}
