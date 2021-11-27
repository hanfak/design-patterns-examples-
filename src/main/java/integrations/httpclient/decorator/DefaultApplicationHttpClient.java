package integrations.httpclient.decorator;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class DefaultApplicationHttpClient implements ApplicationHttpClient {

    private final HttpClient httpClient;

    public DefaultApplicationHttpClient(HttpClient.Builder httpClient) {
        this.httpClient = httpClient.connectTimeout(Duration.ofSeconds(60)).build();
    }

    @Override
    public HttpResponse<String> send(HttpRequest.Builder requestBuilder) throws IOException, InterruptedException {
        return httpClient.send(requestBuilder.build(), ofString());
    }
}
