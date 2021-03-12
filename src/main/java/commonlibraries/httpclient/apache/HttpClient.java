package commonlibraries.httpclient.apache;

import java.io.IOException;
import java.time.Duration;

public interface HttpClient {
    Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    Response execute(Request request, Duration timeout) throws IOException;
}
