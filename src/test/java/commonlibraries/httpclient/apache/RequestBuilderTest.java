package commonlibraries.httpclient.apache;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.Arrays;

import static commonlibraries.httpclient.apache.Streams.concat;
import static java.lang.System.lineSeparator;
import static java.net.HttpCookie.parse;
import static java.util.stream.Collectors.toList;

public class RequestBuilderTest implements WithAssertions {

    @Test
    public void getImpliesEmptyBody() throws Exception {
        Request request = requestBuilder().get().build();

        assertThat(request.method()).isEqualTo("GET");
        assertThat(request.body()).isEqualTo("");
    }

    @Test
    public void bodyCanBeSpecified() throws Exception {
        String body = "I am a body";

        Request request = requestBuilder().body(body).build();

        assertThat(request.body()).isEqualTo(body);
    }

    @Test
    public void noBodyImpliesContentLengthZero() throws Exception {
        Request request = requestBuilder().body("").build();

        assertThat(request.headerValue("Content-Length")).isEqualTo("0");
    }

    @Test
    public void methodCanBeSpecified() throws Exception {
        String method = "GET";

        Request request = requestBuilder().method(method).build();

        assertThat(request.method()).isEqualTo(method);
    }

    @Test
    public void urlCanBeSpecified() throws Exception {
        String url = "http://localhost:8080/hydra/";

        Request request = requestBuilder().url(url).build();

        assertThat(request.url()).isEqualTo(url);
    }

    @Test
    public void queryParameterCanBeSpecified() throws Exception {
        String queryParameterKey = "key";
        String queryParameterValue = "value";

        Request request = requestBuilder().queryParameter(queryParameterKey, queryParameterValue).build();

        assertThat(request.queryParameterValue(queryParameterKey)).isEqualTo(queryParameterValue);
    }

    @Test
    public void queryParametersIterateInInsertionOrder() throws Exception {
        String key1 = "query parameter key 1";
        String value1 = "query parameter  value 1";
        String key2 = "query parameter  key 2";
        String value2 = "query parameter  value 2";

        Request request = requestBuilder()
                .queryParameters(Arrays.asList(new QueryParameter(key1, value1), new QueryParameter(key2, value2)))
                .build();

        assertThat(request.queryParameters()).extracting(queryParameter -> queryParameter.key).containsSubsequence(key1, key2);
    }

    @Test
    public void sameQueryParameterKeyIsCommaSeparated() throws Exception {
        String key = "query key";
        String value1 = "query value 2";
        String value2 = "query value 1";

        Request request = requestBuilder().queryParameter(key, value1).queryParameter(key, value2).build();

        assertThat(request.queryParameterValue(key)).isEqualTo(value1 + "," + value2);
    }

    @Test
    public void headerCanBeSpecified() throws Exception {
        String key = "header key";
        String value = "header value";

        Request request = requestBuilder().header(key, value).build();

        assertThat(request.headerValue(key)).isEqualTo(value);
    }

    @Test
    public void cookiesCanBeSpecified() throws Exception {
        Request request = requestBuilder()
                .cookies(parse("key1=value1"))
                .cookies(parse("key2=value2"))
                .build();

        assertThat(request.cookies()).containsAll(concat(parse("key1=value1"), parse("key2=value2")).collect(toList()));
    }

    @Test
    public void sameHeaderKeyIsCommaSeparated() throws Exception {
        String key = "header key";
        String value1 = "header value 2";
        String value2 = "header value 1";

        Request request = requestBuilder().header(key, value1).header(key, value2).build();

        assertThat(request.headerValue(key)).isEqualTo(value1 + "," + value2);
    }

    @Test
    public void headersIterateInInsertionOrder() throws Exception {
        String key1 = "header key 1";
        String value1 = "header value 1";
        String key2 = "header key 2";
        String value2 = "header value 2";

        Request request = requestBuilder()
                .header(key1, value1)
                .header(key2, value2)
                .build();

        assertThat(request.headers()).extracting(header -> header.key).containsSubsequence(key1, key2);
    }

    @Test
    public void unspecifiedHeadersDefaultToEmptyString() throws Exception {
        String key = "unknown key";

        Request request = requestBuilder().build();

        assertThat(request.headerValue(key)).isEqualTo("");
    }

    @Test
    public void shouldFormatResponseForYatspecOutput() throws Exception {
        String expected = "POST http://localhost:8080/hydra?a=b&c=d" + lineSeparator() +
                "Cache-Control: no-cache" + lineSeparator() +
                "Content-Length: 4" + lineSeparator() + lineSeparator() +
                "body";

        Request request = requestBuilder()
                .method("POST")
                .url("http://localhost:8080/hydra")
                .header("Cache-Control", "no-cache")
                .queryParameter("a", "b")
                .queryParameter("c", "d")
                .body("body")
                .build();

        assertThat(request).hasToString(expected);
    }

    @Test
    public void shouldNotHaveQuestionMarkWhenThereAreNoQueryParameters() throws Exception {
        Request request = requestBuilder().url("http://localhost:8080/hydra").build();

        assertThat(request.toString()).contains("/hydra").doesNotContain("/hydra?");
    }

    @Test
    public void shouldNotBuildWithoutMethod() {
        assertThatThrownBy(() -> new RequestBuilder().url("").body("").build())
                .hasMessage("Method has not been specified");
    }

    @Test
    public void shouldNotBuildWithoutUrl() {
        assertThatThrownBy(() -> new RequestBuilder().method("").body("").build())
                .hasMessage("URL has not been specified");
    }

    @Test
    public void shouldNotBuildWithoutBodyForPostRequest() {
        assertThatThrownBy(() -> new RequestBuilder().method("POST").url("").build())
                .hasMessage("Body has not been specified");
    }

    @Test
    public void shouldNotBuildWithoutBodyForPutRequest() {
        assertThatThrownBy(() -> new RequestBuilder().method("PUT").url("").build())
                .hasMessage("Body has not been specified");
    }

    @Test
    public void shouldBuildOptionsRequest() {
        Request options = new RequestBuilder().options().url("").build();

        assertThat(options.method()).isEqualTo("OPTIONS");
        assertThat(options.body()).isEqualTo("");
    }

    @Test
    public void shouldBuildDeleteRequest() {
        Request delete = new RequestBuilder().delete().url("").build();

        assertThat(delete.method()).isEqualTo("DELETE");
        assertThat(delete.body()).isEqualTo("");
    }

    private RequestBuilder requestBuilder() {
        return new RequestBuilder().method("").url("").body("");
    }
}