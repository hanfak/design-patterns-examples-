package integrations.httpclient.decorator;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface ApplicationHttpClient {
    HttpResponse<String> send(HttpRequest.Builder requestBuilder) throws IOException, InterruptedException;
}
