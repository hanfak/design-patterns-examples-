package apache;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams {

    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> Stream<? extends T> concat(Iterable<? extends T>... iterables) {
        return Arrays.stream(iterables)
                .<Stream<? extends T>>map(Streams::stream)
                .reduce(Stream.empty(), Stream::concat);
    }

    public static <T> Stream<T> stream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
