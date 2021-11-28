package commonlibraries.httpclient.apache;

import java.io.IOException;
import java.time.Duration;

public class HttpClientCustomExampleOne {
    public static void main(String[] args) throws IOException {
        Request request = new RequestBuilder().get().url("http://www.google.com").build();

        Duration maxIdleTime = Duration.ofSeconds(10);
        Response response = new ApacheHttpClient(maxIdleTime).execute(request, maxIdleTime);

        String body = response.body();
        System.out.println("body = " + body);
    }
}
