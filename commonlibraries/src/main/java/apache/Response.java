package apache;


import java.net.HttpCookie;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Response extends ValueType {
    private final String body;
    private final int statusCode;
    private final String protocol;
    private final Headers headers;

    protected Response(String body, int statusCode, String protocol, Headers headers) {
        this.body = body;
        this.statusCode = statusCode;
        this.protocol = protocol;
        this.headers = headers;
    }

    public int statusCode() {
        return statusCode;
    }

    public String body() {
        return body;
    }

    public String protocol() {
        return protocol;
    }

    public Headers headers() {
        return headers;
    }

    public String headerValue(String key) {
        return headers.headerValue(key);
    }

    public List<HttpCookie> cookies() {
        return headers.headerValues("Set-Cookie").stream()
                .map(HttpCookie::parse)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    public ResponseBuilder modify() {
        return new ResponseBuilder()
                .statusCode(statusCode)
                .body(body)
                .headers(headers)
                .protocol(protocol);
    }

    public boolean isSuccessful() {
        return statusCode >= 200 && statusCode < 300;
    }

    public boolean notFound() {
        return statusCode == 404;
    }

    public boolean isClientError() {
        return statusCode == 400;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s%n%n%s", protocol, statusCode, headers, body);
    }
}
