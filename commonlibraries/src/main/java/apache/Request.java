package apache;

import java.net.HttpCookie;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@SuppressWarnings("PMD.TooManyMethods")
public class Request extends ValueType {
    private final String url;
    private final String method;
    private final Headers headers;
    private final QueryParameters queryParameters;
    private final String body;

    protected Request(String url, String method, Headers headers, QueryParameters queryParameters, String body) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.queryParameters = queryParameters;
        this.body = body;
    }

    public String method() {
        return method;
    }

    public String url() {
        return url;
    }

    public Headers headers() {
        return headers;
    }

    public String headerValue(String headerKey) {
        return headers.headerValue(headerKey);
    }

    public QueryParameters queryParameters() {
        return queryParameters;
    }

    public String queryParameterValue(String queryParameterKey) {
        return queryParameters.queryParameterValue(queryParameterKey);
    }

    public String body() {
        return body;
    }

    public List<HttpCookie> cookies() {
        return headers.headerValues("Cookie").stream()
                .map(HttpCookie::parse)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    public RequestBuilder modify() {
        return new RequestBuilder()
                .method(method())
                .headers(headers())
                .url(url())
                .queryParameters(queryParameters())
                .body(body());
    }

    @Override
    public String toString() {
        return String.format("%s %s%s%n%s%n%n%s", method, url, queryParameters, headers, body);
    }
}
