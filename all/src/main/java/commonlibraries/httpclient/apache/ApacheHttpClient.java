package commonlibraries.httpclient.apache;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.net.ssl.SSLSocketFactory;
import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApacheHttpClient implements HttpClient, Closeable {

    private final CloseableHttpClient client;
    private final ApacheHttpClientAdapters adapters;

    public ApacheHttpClient(ApacheHttpClientAdapters adapters, CloseableHttpClient client) {
        this.adapters = adapters;
        this.client = client;
    }

    public ApacheHttpClient(Duration maxIdleTime) {
        this(new ApacheHttpClientAdapters(), commonConfiguration(maxIdleTime).build());
    }

    public ApacheHttpClient(Duration maxIdleTime, SSLSocketFactory sslSocketFactory) {
        this.adapters = new ApacheHttpClientAdapters();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslSocketFactory, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        this.client = commonConfiguration(maxIdleTime).setSSLSocketFactory(sslConnectionSocketFactory).build();
    }

    private static HttpClientBuilder commonConfiguration(Duration maxIdleTime) {
        return HttpClientBuilder.create()
                .evictIdleConnections(maxIdleTime.getSeconds(), TimeUnit.SECONDS)
                .disableCookieManagement();
    }

    @Override
    public Response execute(Request request, Duration timeout) throws IOException {
        try (CloseableHttpResponse response = client.execute(adapters.adaptRequest(request, timeout))) {
            return adapters.adaptResponse(response);
        }
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
