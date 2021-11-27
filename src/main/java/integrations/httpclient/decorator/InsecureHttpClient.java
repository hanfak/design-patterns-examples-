package integrations.httpclient.decorator;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class InsecureHttpClient implements ApplicationHttpClient {

    private final HttpClient httpClient;

    public InsecureHttpClient() {
        httpClient = HttpClient.newBuilder()
                .sslContext(createInsecureSSLContext())
                .build();
    }

    @Override
    public HttpResponse<String> send(HttpRequest.Builder requestBuilder) throws IOException, InterruptedException {
        return httpClient.send(requestBuilder.build(), ofString());
    }

    private SSLContext createInsecureSSLContext() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) { }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) { }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            }, null);
            return sslContext;
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new IllegalStateException(e);
        }
    }
}
