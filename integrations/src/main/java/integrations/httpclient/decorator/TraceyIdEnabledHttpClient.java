package integrations.httpclient.decorator;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TraceyIdEnabledHttpClient implements ApplicationHttpClient {
    private final ApplicationHttpClient delegate;

    public TraceyIdEnabledHttpClient(ApplicationHttpClient delegate) {
        this.delegate = delegate;
    }

    @Override
    public HttpResponse<String> send(HttpRequest.Builder requestBuilder) throws IOException, InterruptedException {
        requestBuilder.setHeader("Tracey-id", traceyId());
        requestBuilder.setHeader("X-Source", "application");
        return delegate.send(requestBuilder);
    }

    private String traceyId() {
        return TraceyId.hasValue() ? TraceyId.get() : TraceyId.makeOneUp();
    }
}
