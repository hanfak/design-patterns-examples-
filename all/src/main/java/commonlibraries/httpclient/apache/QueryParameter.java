package commonlibraries.httpclient.apache;


import java.util.List;

import static java.util.stream.Collectors.joining;

public class QueryParameter extends ValueType {
    public final String key;
    public final String value;

    public QueryParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public QueryParameter(String key, List<String> values) {
        this.key = key;
        this.value = values.stream().collect(joining(","));
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
