package functional.either._02;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Either<L, R> {

    private final L left;
    private final R right;
    private final boolean isLeft;

    private Either(L left, R right, boolean isLeft) {
        this.left = left;
        this.right = right;
        this.isLeft = isLeft;
    }

    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(value, null, true);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(null, value, false);
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return !isLeft;
    }

    public <T> T map(Function<L, T> leftMapper, Function<R, T> rightMapper) {
        if (isLeft) {
            return leftMapper.apply(left);
        }
        return rightMapper.apply(right);
    }

    public <T> Either<L, T> flatMap(Function<L, Either<L, T>> leftMapper, Function<R, Either<L, T>> rightMapper) {
        return isLeft ? leftMapper.apply(left) : rightMapper.apply(right);
    }

    public void ifLeft(Consumer<L> action) {
        if (isLeft) {
            action.accept(left);
        }
    }

    public void ifRight(Consumer<R> action) {
        if (!isLeft) {
            action.accept(right);
        }
    }

    public Optional<L> getLeft() {
        return Optional.ofNullable(left);
    }

    public Optional<R> getRight() {
        return Optional.ofNullable(right);
    }

    public R orElse(R defaultValue) {
        if (isRight()) {
            return right;
        } else {
            return defaultValue;
        }
    }

    public R orElseGet(Supplier<R> defaultValueSupplier) {
        if (isRight()) {
            return right;
        } else {
            return defaultValueSupplier.get();
        }
    }

    public R orElseThrow(Supplier<? extends RuntimeException> exceptionSupplier) {
        if (isRight()) {
            return right;
        } else {
            throw exceptionSupplier.get();
        }
    }

    public Either<L, R> filter(Predicate<R> predicate, L errorMessage) {
        if (isRight()) {
            if (predicate.test(right)) {
                return this;
            }
            return Either.left(errorMessage);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Either<?, ?> either = (Either<?, ?>) o;
        return isLeft == either.isLeft && Objects.equals(left, either.left) && Objects.equals(right, either.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, isLeft);
    }
}

