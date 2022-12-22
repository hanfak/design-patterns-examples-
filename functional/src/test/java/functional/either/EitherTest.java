package functional.either;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EitherTest {
    @Test
    public void testEitherLeft() {
        final Either<Integer, String> l = Either.left(5);

        int v = l.fold(Integer::intValue, String::length);
        assertEquals(5, v);

        final Either<Long, String> w = l.map(Long::valueOf, a -> a);
        v = w.fold(Long::intValue, String::length);
        assertEquals(5, v);

        final Either<Integer, String> r = l.fold(
                a -> Either.right(Integer.valueOf(a + 1).toString()),
                b -> Either.left(b.length()));
        assertEquals("6", r.fold(a -> a.toString(), b -> b));

        final AtomicInteger i = new AtomicInteger();
        l.forEach(i::addAndGet, b -> i.addAndGet(b.length()));
        assertEquals(5, i.get());
    }

    @Test
    public void testEitherRight() {
        final Either<Integer, String> l = Either.right("String!");

        int v = l.fold(Integer::intValue, String::length);
        assertEquals(7, v);

        final Either<Long, String> w = l.map(Long::valueOf, a -> a);
        v = w.fold(Long::intValue, String::length);
        assertEquals(7, v);

        final Either<Integer, String> r = l.fold(
                a -> Either.right(Integer.valueOf(a + 1).toString()),
                b -> Either.left(b.length()));
        assertEquals("7", r.fold(a -> a.toString(), b -> b));

        final AtomicInteger i = new AtomicInteger();
        l.forEach(i::addAndGet, b -> i.addAndGet(b.length()));
        assertEquals(7, i.get());
    }

    @Test
    public void testRightLeftEither() {
        final Either<Integer, String> l = Either.right("String!");

        int v = l.fold(Integer::intValue, String::length);
        assertEquals(7, v);

        final Either<Long, String> w = l.map(Long::valueOf, a -> a);
        v = w.fold(Long::intValue, String::length);
        assertEquals(7, v);

        final Either<Integer, String> r = l.fold(
                a -> Either.right(Integer.valueOf(a + 1).toString()),
                b -> Either.left(b.length()));
        assertEquals("7", r.fold(a -> a.toString(), b -> b));

        final AtomicInteger i = new AtomicInteger();
        l.forEach(i::addAndGet, b -> i.addAndGet(b.length()));
        assertEquals(7, i.get());
    }
}