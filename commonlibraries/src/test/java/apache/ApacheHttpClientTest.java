package apache;

import apache.examples.WithExamples;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static apache.HttpClient.DEFAULT_TIMEOUT;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApacheHttpClientTest extends WireMockTest implements WithAssertions, WithExamples {

    private final CloseableHttpClient closeableHttpClient = mock(CloseableHttpClient.class);
    private final ApacheHttpClientAdapters apacheHttpClientAdapters = mock(ApacheHttpClientAdapters.class);
    private final HttpUriRequest httpUriRequest = mock(HttpUriRequest.class);
    private final CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class);

    @Test
    public void closableResponseIsClosed() throws IOException {
        Request request = postWithBody("test request");
        when(apacheHttpClientAdapters.adaptRequest(request, DEFAULT_TIMEOUT)).thenReturn(httpUriRequest);
        when(closeableHttpClient.execute(httpUriRequest)).thenReturn(closeableHttpResponse);
        when(apacheHttpClientAdapters.adaptResponse(closeableHttpResponse)).thenReturn(responseWithBody("test response"));

        new ApacheHttpClient(apacheHttpClientAdapters, closeableHttpClient).execute(request, DEFAULT_TIMEOUT);

        verify(closeableHttpResponse).close();
    }

    @Test(expected = IOException.class)
    public void shouldThrowIoExceptionWhenTheTargetIsUnreachable() throws IOException {
        httpClient().execute(new RequestBuilder().get().url("http://localhost:9999/badurl").build(), DEFAULT_TIMEOUT);
    }

    @Test(expected = IOException.class)
    public void shouldThrowMalformedURLExceptionWhenInvalidUrlIsPassed() throws Exception {
        httpClient().execute(new RequestBuilder().get().url("badurl").build(), DEFAULT_TIMEOUT);
    }

    @Test
    public void shouldRetrieveNoContentResponse() throws IOException {
        givenThat(post(urlPathEqualTo("/test")).willReturn(aResponse().withStatus(204)));

        Request request = new RequestBuilder().post().body("").url(baseUrl() + "/test").build();

        Response response = httpClient().execute(request, DEFAULT_TIMEOUT);

        assertThat(response)
                .hasStatusCode(204)
                .hasBody("");
    }

    @Test
    public void shouldRetrieveSuccessfulResponse() throws IOException {
        givenThat(post(urlPathEqualTo("/test")).willReturn(aResponse()
                .withStatus(200)
                .withBody("some body")
                .withHeader("header key", "header value")));

        Request request = new RequestBuilder().post()
                .header("Content-Type", "text/plain")
                .body("some body")
                .url(baseUrl() + "/test")
                .build();

        Response response = httpClient().execute(request, DEFAULT_TIMEOUT);

        assertThat(response)
                .hasStatusCode(200)
                .hasBody("some body")
                .hasHeader("header key", "header value");
    }

    @Test
    public void shouldPassParameters() throws IOException {
        givenThat(get(urlPathEqualTo("/test")).withQueryParam("parameter", equalTo("value")).willReturn(aResponse()
                .withStatus(200)
                .withBody("some body")
                .withHeader("header key", "header value")));

        Request request = new RequestBuilder().get().url(baseUrl() + "/test").queryParameter("parameter", "value").build();

        Response response = httpClient().execute(request, DEFAULT_TIMEOUT);

        assertThat(response)
                .hasStatusCode(200)
                .hasBody("some body")
                .hasHeader("header key", "header value");
    }

    @Test
    public void shouldPassContentType() throws IOException {
        Request request = new RequestBuilder().post().url(baseUrl() + "/test")
                .header("Content-Type", "application/xml")
                .body("body").build();

        httpClient().execute(request, DEFAULT_TIMEOUT);

        verifyThat(postRequestedFor(urlPathEqualTo("/test"))
                .withRequestBody(equalTo("body"))
                .withHeader("Content-Type", equalTo("application/xml")));
    }

    @Test
    public void shouldPassHeaders() throws IOException {
        Request request = new RequestBuilder().post()
                .url(baseUrl() + "/test")
                .header("Content-Type", "text/plain")
                .header("Some-Header", "Some-Value").body("body").build();

        httpClient().execute(request, DEFAULT_TIMEOUT);

        verifyThat(postRequestedFor(urlPathEqualTo("/test"))
                .withRequestBody(equalTo("body"))
                .withHeader("Some-Header", equalTo("Some-Value")));
    }

    @Test
    public void timeoutResultsInIOException() throws IOException {
        givenThat(post(urlPathEqualTo("/test")).willReturn(aResponse()
                .withFixedDelay(1000)));

        Request request = new RequestBuilder().post().body("").url(baseUrl() + "/test").build();

        assertThatThrownBy(() -> httpClient().execute(request, Duration.ofMillis(1)))
            .isInstanceOf(IOException.class);
    }

    private HttpClient httpClient() {
        return new ApacheHttpClient(Duration.ofSeconds(3600));
    }
}
