package integrations.httpclient.decorator;

import org.slf4j.Logger;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Supplier;

import static java.lang.String.format;

public class LoggingHttpClient implements ApplicationHttpClient {
    private final ApplicationHttpClient httpClient;
    private final Logger auditLogger;
    private final Supplier<Timer> timerSupplier;
    private final HttpRequestFormatter requestFormatter;
    private final HttpResponseFormatter httpResponseFormatter;

    public LoggingHttpClient(ApplicationHttpClient httpClient, Logger auditLogger, Supplier<Timer> timerSupplier, HttpRequestFormatter requestFormatter, HttpResponseFormatter httpResponseFormatter) {
        this.httpClient = httpClient;
        this.auditLogger = auditLogger;
        this.timerSupplier = timerSupplier;
        this.requestFormatter = requestFormatter;
        this.httpResponseFormatter = httpResponseFormatter;
    }

    @Override
    public HttpResponse<String> send(HttpRequest.Builder requestBuilder) throws IOException, InterruptedException {
        HttpRequest request = requestBuilder.build();
        String requestUrl = request.uri().toString();
        auditLogger.info(format("Request from Switcheroo to %s%n%s", requestUrl, requestFormatter.formatRequest(request)));
        Timer timer = timerSupplier.get();
        HttpResponse<String> response = tryToSendRequest(requestBuilder, requestUrl, timer, request);
        Duration elapsedTime = timer.elapsedTime();
        auditLogger.info(format("Response from %s to Switcheroo received after %dms%n%s", requestUrl, elapsedTime.toMillis(), httpResponseFormatter.formatResponse(response)));
        return response;
    }

    private HttpResponse<String> tryToSendRequest(HttpRequest.Builder requestBuilder, String requestUrl,  Timer timer, HttpRequest request) throws IOException, InterruptedException {
        try {
            return httpClient.send(requestBuilder);
        } catch (RuntimeException exception) {
            Duration elapsedTime = timer.elapsedTime();
            auditLogger.error(format("Failed to execute request from Switcheroo to %s after %dms\n%s", requestUrl, elapsedTime.toMillis(), requestFormatter.formatRequest(request)), exception);
            throw exception;
        }
    }
}
