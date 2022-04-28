package apache;

import org.junit.Test;

import java.util.Arrays;

import static java.net.HttpCookie.parse;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class ResponseBuilderTest implements WithAssertions {

    @Test
    public void statusCodeCanBeSpecified() throws Exception {
        int statusCode = 200;

        Response response = responseBuilder().statusCode(statusCode).build();

        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Test
    public void bodyCanBeSpecified() throws Exception {
        String body = "i am a body";

        Response response = responseBuilder().body(body).build();

        assertThat(response.body()).isEqualTo(body);
    }

    @Test
    public void headerCanBeSpecified() throws Exception {
        String key = "header key";
        String value = "header value";

        Response response = responseBuilder().header(key, value).build();

        assertThat(response.headerValue(key)).isEqualTo(value);
    }

    @Test
    public void headersCanBeSpecified() throws Exception {
        String key = "header key";
        String value = "header value";

        Response response = responseBuilder().header(key, value).build();

        assertThat(response.headerValue(key)).isEqualTo(value);
    }

    @Test
    public void sameHeaderKeyIsCommaSeparated() throws Exception {
        String key = "header key";
        String value1 = "header value 2";
        String value2 = "header value 1";

        Response response = responseBuilder().header(key, value1).header(key, value2).build();

        assertThat(response.headerValue(key)).isEqualTo(value1 + "," + value2);
    }

    @Test
    public void headersIterateInInsertionOrder() throws Exception {
        String key1 = "header key 1";
        String value1 = "header value 1";
        String key2 = "header key 2";
        String value2 = "header value 2";

        Response response = responseBuilder()
                .headers(Arrays.asList(new Header(key1, value1), new Header(key2, value2)))
                .build();

        assertThat(response.headers()).extracting(header -> header.key).containsSequence(key1, key2);
    }

    @Test
    public void unspecifiedHeadersDefaultToEmptyString() throws Exception {
        String key = "unknown key";

        Response response = responseBuilder().build();

        assertThat(response.headerValue(key)).isEqualTo("");
    }

    @Test
    public void protocolCanBeSpecified() throws Exception {
        String protocol = "HTTP/1.1";

        Response response = responseBuilder().protocol(protocol).build();

        assertThat(response.protocol()).isEqualTo(protocol);
    }

    @Test
    public void cookiesCanBeSpecified() throws Exception {
        String cookie1 = "key1=value1; Expires=Wed, 09 Jun 2021 10:18:14 GMT";
        String cookie2 = "key2=value2; Expires=Wed, 10 Jun 2021 10:18:14 GMT";
        Response response = responseBuilder()
                .header("Set-Cookie", cookie1)
                .header("Set-Cookie", cookie2)
                .build();

        assertThat(response.cookies()).isEqualTo(Streams.concat(parse(cookie1), parse(cookie2)).collect(toList()));
    }

    @Test
    public void shouldFormatResponseForYatspecOutput() throws Exception {
        String expected = "HTTP/1.1 123" + System.lineSeparator() +
                "Cache-Control: no-cache" + System.lineSeparator() +
                "Content-Length: " + "I am a body".length() + System.lineSeparator() + System.lineSeparator() +
                "I am a body";

        Response response = responseBuilder()
                .protocol("HTTP/1.1")
                .header("Cache-Control", "no-cache")
                .body("I am a body")
                .statusCode(123)
                .build();

        assertEquals(expected, response.toString());
    }

    @Test
    public void shouldNotBuildWithoutBody() {
        assertThatThrownBy(() -> new ResponseBuilder().statusCode(-1).protocol("").build())
                .hasMessage("Body has not been specified");
    }

    @Test
    public void shouldNotBuildWithoutStatusCode() {
        assertThatThrownBy(() -> new ResponseBuilder().body("").protocol("").build())
                .hasMessage("Status code has not been specified");
    }

    @Test
    public void shouldNotBuildWithoutProtocol() {
        assertThatThrownBy(() -> new ResponseBuilder().body("").statusCode(-1).build())
                .hasMessage("Protocol has not been specified");
    }

    private ResponseBuilder responseBuilder() {
        return new ResponseBuilder().body("").statusCode(-1).protocol("");
    }
}