package commonlibraries.httpclient.apache;


import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.joining;

public class QueryParameters extends ValueType implements Iterable<QueryParameter> {

    private final Map<String, String> queryParameters;

    QueryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    String queryParameterValue(String key) {
        return Optional.ofNullable(queryParameters.get(key)).orElse("");
    }

    @Override
    public Iterator<QueryParameter> iterator() {
        return queryParameters.entrySet().stream()
                .map(entry -> new QueryParameter(entry.getKey(), entry.getValue()))
                .iterator();
    }

    @Override
    public String toString() {
        if (queryParameters.isEmpty()) {
            return "";
        }
        Stream<QueryParameter> stream = StreamSupport.stream(spliterator(), false);
        return stream.map(QueryParameter::toString).collect(joining("&", "?", ""));
    }
}
