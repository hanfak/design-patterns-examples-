package functional.either._02;

import org.junit.Test;

import static org.junit.Assert.*;

public class EitherTest {
    @Test
    public void testMap() {
        Either<String, Integer> left = Either.left("error");
        Either<String, Integer> right = Either.right(5);

        assertEquals("Left value: error", left.map(l -> "Left value: " + l, r -> "Right value: " + r));
        assertEquals("Right value: 5", right.map(l -> "Left value: " + l, r -> "Right value: " + r));
    }

    @Test
    public void testFlatMap() {
        Either<String, Integer> left = Either.left("error");
        Either<String, Integer> right = Either.right(5);

        assertEquals(Either.left("Left value: error"), left.flatMap(l -> Either.left("Left value: " + l), r -> Either.right("Right value: " + r)));
        assertEquals(Either.right("Right value: 5"), right.flatMap(l -> Either.left("Left value: " + l), r -> Either.right("Right value: " + r)));
    }

    @Test
    public void testIfLeft() {
        Either<String, Integer> left = Either.left("error");
        Either<String, Integer> right = Either.right(5);

        final String[] leftValue = {null};
        final String[] rightValue = {null};
        left.ifLeft(val -> leftValue[0] = val);
        right.ifLeft(val -> leftValue[0] = val);

        assertEquals("error", leftValue[0]);
        assertEquals(null, rightValue[0]);
    }

    @Test
    public void testIfRight() {
        Either<String, Integer> left = Either.left("error");
        Either<String, Integer> right = Either.right(5);

        final Integer[] leftValue = {null};
        final Integer[] rightValue = {null};
        left.ifRight(val -> rightValue[0] = val);
        right.ifRight(val -> rightValue[0] = val);

        assertEquals(null, leftValue[0]);
        assertEquals(new Integer(5), rightValue[0]);
    }

    @Test
    public void testIsLeft() {
        Either<String, Integer> left = Either.left("error");
        Either<String, Integer> right = Either.right(5);

        assertTrue(left.isLeft());
        assertFalse(right.isLeft());
    }

    @Test
    public void testIsRight() {
        Either<String, Integer> left = Either.left("error");
        Either<String, Integer> right = Either.right(5);

        assertFalse(left.isRight());
        assertTrue(right.isRight());
    }

    @Test
    public void testMap_null_left() {
        Either<String, Integer> left = Either.left(null);
        Either<String, Integer> right = Either.right(5);

        assertEquals("Left value: null", left.map(l -> "Left value: " + l, r -> "Right value: " + r));
        assertEquals("Right value: 5", right.map(l -> "Left value: " + l, r -> "Right value: " + r));
    }

    @Test
    public void testMap_null_right() {
        Either<String, Integer> left = Either.left("error");
        Either<String, Integer> right = Either.right(null);

        assertEquals("Left value: error", left.map(l -> "Left value: " + l, r -> "Right value: " + r));
        assertEquals("Right value: null", right.map(l -> "Left value: " + l, r -> "Right value: " + r));
    }

    @Test(expected = NullPointerException.class)
    public void testFlatMap_left_throws_exception() {
        Either<String, Integer> left = Either.left("error");
        left.flatMap(l -> {throw new NullPointerException();}, r -> Either.right("Right value: " + r));
    }

    @Test(expected = NullPointerException.class)
    public void testFlatMap_right_throws_exception() {
        Either<String, Integer> right = Either.right(5);
        right.flatMap(l -> Either.left("Left value: " + l), r -> {throw new NullPointerException();});
    }

    @Test
    public void testIfLeft_null_left() {
        Either<String, Integer> left = Either.left(null);
        final String[] leftValue = {null};
        left.ifLeft(val -> leftValue[0] = val);
        assertEquals(null, leftValue[0]);
    }

    @Test
    public void testIfRight_null_right() {
        Either<String, Integer> right = Either.right(null);
        final Integer[] rightValue = {null};
        right.ifRight(val -> rightValue[0] = val);
        assertEquals(null, rightValue[0]);
    }

    @Test
    public void testGetLeft() {
        Either<String, Integer> either = Either.left("error");
        assertEquals("error", either.getLeft().get());
    }

    @Test
    public void testGetRight() {
        Either<String, Integer> either = Either.right(5);
        assertEquals(5, either.getRight().get().intValue());
    }

    @Test
    public void testOrElse_right() {
        Either<String, Integer> either = Either.right(5);
        assertEquals(5, either.orElse(-1).intValue());
    }

    @Test
    public void testOrElse_left() {
        Either<String, Integer> either = Either.left("error");
        assertEquals(-1, either.orElse(-1).intValue());
    }

    @Test
    public void testOrElseGet_right() {
        Either<String, Integer> either = Either.right(5);
        assertEquals(5, either.orElseGet(() -> -1).intValue());
    }

    @Test
    public void testOrElseGet_left() {
        Either<String, Integer> either = Either.left("error");
        assertEquals(-1, either.orElseGet(() -> -1).intValue());
    }

    @Test
    public void testOrElseThrow_right() {
        Either<String, Integer> either = Either.right(5);
        assertEquals(5, either.orElseThrow(() -> new RuntimeException("error")).intValue());
    }

    @Test
    public void testOrElseThrow_left() {
        Either<String, Integer> either = Either.left("error");
        try {
            either.orElseThrow(() -> new RuntimeException("error"));
            fail();
        } catch (RuntimeException e) {
            assertEquals("error", e.getMessage());
        }
    }

    @Test
    public void testFilter_right_true() {
        Either<String, Integer> either = Either.right(5);
        Either<String, Integer> filteredEither = either.filter(i -> i > 0, "error");
        assertTrue(filteredEither.isRight());
        assertEquals(5, filteredEither.getRight().get().intValue());
    }

    @Test
    public void testFilter_right_false() {
        Either<String, Integer> either = Either.right(-5);
        Either<String, Integer> filteredEither = either.filter(i -> i > 0, "error");
        assertTrue(filteredEither.isLeft());
        assertEquals("error", filteredEither.getLeft().get());
    }

    @Test
    public void testFilter_left() {
        Either<String, Integer> either = Either.left("error");
        Either<String, Integer> filteredEither = either.filter(i -> i > 0, "filter error");
        assertTrue(filteredEither.isLeft());
        assertEquals("error", filteredEither.getLeft().get());
    }
}
