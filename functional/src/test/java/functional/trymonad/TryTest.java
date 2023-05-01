package functional.trymonad;


import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TryTest {

    @Test
    void testOfCheckedSuccess() throws Exception {
        Try<Integer> result = Try.of(() -> 10 / 2);
        assertTrue(result.isSuccess());
        assertEquals(5, result.get());
    }

    @Test
    void testOfCheckedFailure() {
        Try<Integer> result = Try.of(() -> 10 / 0);
        assertTrue(result.isFailure());
        assertThrows(ArithmeticException.class, result::get);
    }

    @Test
    void testMapSuccess() throws Exception {
        Try<Integer> result = Try.of(() -> 10 / 2)
                .map(x -> x * 2);
        assertTrue(result.isSuccess());
        assertEquals(10, result.get());
    }

    @Test
    void testMapFailure() {
        Try<Integer> result = Try.of(() -> 10 / 0)
                .map(x -> x * 2);
        assertTrue(result.isFailure());
        assertThrows(ArithmeticException.class, result::get);
    }

    @Test
    void testOnFailureSuccess() throws Exception {
        StringBuilder message = new StringBuilder();
        Try<Integer> result = Try.of(() -> 10 / 2)
                .onFailure(ex -> message.append(ex.getMessage()));
        assertTrue(result.isSuccess());
        assertEquals("", message.toString());
    }

    @Test
    void testOnFailureFailure() throws Exception {
        StringBuilder message = new StringBuilder();
        Try<Integer> result = Try.of(() -> 10 / 0)
                .onFailure(ex -> message.append(ex.getMessage()));
        assertTrue(result.isFailure());
        assertEquals("/ by zero", message.toString());
    }

    @Test
    void testGetOrElseSuccess() {
        Try<Integer> result = Try.of(() -> 10 / 2);
        assertEquals(5, result.getOrElse(0));
    }

    @Test
    void testGetOrElseFailure() {
        Try<Integer> result = Try.of(() -> 10 / 0);
        assertEquals(0, result.getOrElse(0));
    }

    @Test
    void testToOptionalSuccess() {
        Try<Integer> result = Try.of(() -> 10 / 2);
        assertTrue(result.toOptional().isPresent());
        assertEquals(5, result.toOptional().get());
    }

    @Test
    void testToOptionalFailure() {
        Try<Integer> result = Try.of(() -> 10 / 0);
        assertTrue(result.toOptional().isEmpty());
    }

    @Test
    void testRecoverSuccess() throws Exception {
        Try<Integer> result = Try.of(() -> 10 / 2)
                .recover(ArithmeticException.class, ex -> 0);
        assertTrue(result.isSuccess());
        assertEquals(5, result.get());
    }

    @Test
    void testRecoverFailure() throws Exception {
        Try<Integer> result = Try.of(() -> 10 / 0)
                .recover(ArithmeticException.class, ex -> 0);
        assertTrue(result.isSuccess());
        assertEquals(0, result.get());
    }

    @Test
    void testFilterSuccess() throws Exception {
        Try<Integer> result = Try.of(() -> 10 / 2)
                .filter(x -> x % 2 == 0);
        assertThrows(NoSuchElementException.class, result::get);
    }

    @Test
    void testFilterFailure() {
        Try<Integer> result = Try.of(() -> 10 / 3)
                .filter(x -> x % 2 == 0);
        assertTrue(result.isFailure());
        assertThrows(NoSuchElementException.class, result::get);
    }

    @Test
    public void testMapTrySuccess() throws Exception {
        Try<Integer> result = Try.of(() -> 10)
                .mapTry(x -> x * 2);
        assertTrue(result.isSuccess());
        assertEquals(20, result.get().intValue());
    }

    @Test
    public void testMapTryFailure() throws Exception {
        Try<Integer> result = Try.of(() -> 10)
                .mapTry(x -> {
                    if (x > 5) {
                        throw new RuntimeException("Invalid number: " + x);
                    }
                    return x;
                });
        assertTrue(result.isFailure());
        assertTrue(result.toOptional().isEmpty());
        assertThrows(RuntimeException.class, result::get);
    }

    @Test
    public void testMapTryRecover() throws Exception {
        Try<Integer> result = Try.of(() -> 10)
                .mapTry(x -> {
                    if (x > 5) {
                        throw new RuntimeException("Invalid number: " + x);
                    }
                    return x;
                })
                .recover(RuntimeException.class, ex -> 0);
        assertTrue(result.isSuccess());
        assertEquals(0, result.get().intValue());
    }

}