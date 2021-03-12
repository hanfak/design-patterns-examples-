package commonlibraries.httpclient.apache;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class Headers extends ValueType implements Iterable<Header> {

    private final Multimap<String, String> headers;

    Headers(Multimap<String, String> headers) {
        this.headers = headers;
    }

    String headerValue(String key) {
        return headers.get(key).stream().collect(joining(","));
    }

    Collection<String> headerValues(String key) {
        return headers.get(key);
    }

    public Multimap<String, String> asMultiMap() {
        return Multimaps.unmodifiableMultimap(headers);
    }

    @Override
    public Iterator<Header> iterator() {
        return headers.entries().stream()
                .map(entry -> new Header(entry.getKey(), entry.getValue()))
                .iterator();
    }

    @Override
    public String toString() {
        Stream<Header> stream = StreamSupport.stream(spliterator(), false);
        return stream.map(Header::toString).collect(joining(lineSeparator()));
    }
}
