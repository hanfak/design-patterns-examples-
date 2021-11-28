package commonlibraries.httpclient.apache;

import org.assertj.core.api.AbstractObjectAssert;

import static java.net.HttpCookie.parse;
import static org.assertj.core.api.Assertions.assertThat;

public class ThenTheRequest extends AbstractObjectAssert<ThenTheRequest, Request> {

    private final Request request;

    public ThenTheRequest(Request request) {
        super(request, ThenTheRequest.class);
        this.request = request;
    }

    public ThenTheRequest hasUrl(String url) {
        assertThat(request.url()).isEqualTo(url);
        return this;
    }

    public ThenTheRequest hasBody(String body) {
        assertThat(request.body()).isEqualTo(body);
        return this;
    }

    public ThenTheRequest hasHeader(String headerKey, String headerValue) {
        assertThat(request.headerValue(headerKey)).isEqualTo(headerValue);
        return this;
    }

    public ThenTheRequest hasHeaderMatching(String headerKey, String headerValueRegex) {
        assertThat(request.headerValue(headerKey)).matches(headerValueRegex);
        return this;
    }

    public ThenTheRequest hasMethod(String method) {
        assertThat(request.method()).isEqualTo(method);
        return this;
    }

    public ThenTheRequest hasCookie(String exampleHeaderCookie) {
        assertThat(request.cookies()).containsAll(parse(exampleHeaderCookie));
        return this;
    }
}
