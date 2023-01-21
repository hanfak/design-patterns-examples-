package functional.either._01;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Either<LEFT, RIGHT> {

    <V> V fold(
            final Function<? super LEFT, ? extends V> leftFn,
            final Function<? super RIGHT, ? extends V> rightFn);

    static <A, B> Either<A, B> left(final A a) {
        return new Either<>() {

            @Override
            public <V> V fold(
                    final Function<? super A, ? extends V> leftFn,
                    final Function<? super B, ? extends V> rightFn) {
                return leftFn.apply(a);
            }

            @Override
            public String toString() {
                if (a == null) {
                    return "Left (null type): null";
                } else {
                    return String.format("Left (%s): %s", a.getClass(), a);
                }
            }
        };
    }

    static <A, B> Either<A, B> right(final B b) {
        return new Either<>() {

            @Override
            public <V> V fold(
                    final Function<? super A, ? extends V> leftFn,
                    final Function<? super B, ? extends V> rightFn) {
                return rightFn.apply(b);
            }

            @Override
            public String toString() {
                if (b == null) {
                    return "Right (null type): null";
                } else {
                    return String.format("Right (%s): %s", b.getClass(), b);
                }
            }
        };
    }

    default boolean isLeft() {
        return fold(left -> true, right -> false);
    }

    default boolean isRight() {
        return fold(left -> false, right -> true);
    }

    default Optional<LEFT> left() {
        return fold(Optional::of, r -> Optional.empty());
    }

    default Optional<RIGHT> right() {
        return fold(l -> Optional.empty(), Optional::of);
    }

    default <A, B> Either<A, B> map(
            final Function<? super LEFT, ? extends A> leftFn,
            final Function<? super RIGHT, ? extends B> rightFn) {
        return fold(
                left -> Either.left(leftFn.apply(left)),  right -> Either.right(rightFn.apply(right)));
    }

    default <V> Either<LEFT, V> map(final Function<? super RIGHT, ? extends V> fn) {
        return fold(Either::left, r -> Either.right(fn.apply(r)));
    }

    default <V> Either<LEFT, V> flatMap(
            final Function<? super RIGHT, ? extends Either<LEFT, V>> f) {
        return fold(Either::left, f);
    }

    default void forEach(
            final Consumer<? super LEFT> leftConsumer, final Consumer<? super RIGHT> rightConsumer) {
        fold(
                left -> {
                    leftConsumer.accept(left);
                    return null;
                },
                right -> {
                    rightConsumer.accept(right);
                    return null;
                });
    }
}
