package apache;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import static commonlibraries.httpclient.apache.Header.CONTENT_LENGTH_KEY;
import static commonlibraries.httpclient.apache.Header.CONTENT_TYPE_KEY;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.apache.http.client.config.RequestConfig.DEFAULT;

public class ApacheHttpClientAdapters {

    public HttpUriRequest adaptRequest(Request request, Duration timeout) throws IOException {
        GenericHttpUriRequest httpUriRequest = new GenericHttpUriRequest(request.method(), adaptUrl(request), requestConfigWithTimeout(timeout));
        adaptBody(request, httpUriRequest);
        httpUriRequest.setHeaders(adaptHeaders(request));
        return httpUriRequest;
    }

    public Response adaptResponse(HttpResponse response) throws IOException {
        return new ResponseBuilder()
                .protocol(adaptProtocol(response))
                .body(adaptBody(response))
                .headers(adaptHeaders(response))
                .statusCode(adaptStatusCode(response))
                .build();
    }

    private int adaptStatusCode(HttpResponse response) {
        return response.getStatusLine().getStatusCode();
    }

    private String adaptBody(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            return "";
        }
        return EntityUtils.toString(entity);
    }

    private List<Header> adaptHeaders(HttpResponse response) {
        return stream(response.getAllHeaders()).map(this::adaptHeader).collect(toList());
    }

    private Header adaptHeader(org.apache.http.Header header) {
        return new Header(header.getName(), header.getValue());
    }

    private String adaptProtocol(HttpResponse response) {
        return response.getProtocolVersion().toString().toUpperCase();
    }

    private RequestConfig requestConfigWithTimeout(Duration connectionTimeout) {
        int connectionRequestTimeoutInMillis = (int) connectionTimeout.toMillis();
        return RequestConfig.copy(DEFAULT)
                .setConnectionRequestTimeout(connectionRequestTimeoutInMillis)
                .setConnectTimeout(connectionRequestTimeoutInMillis)
                .setSocketTimeout(connectionRequestTimeoutInMillis)
                .build();
    }

    private void adaptBody(Request request, GenericHttpUriRequest httpUriRequest) {
        if (!request.body().isEmpty()) {
            httpUriRequest.setEntity(new StringEntity(request.body(), ContentType.parse(request.headerValue(CONTENT_TYPE_KEY))));
        }
    }

    private org.apache.http.Header[] adaptHeaders(Request request) {
        return request.headers().asMultiMap().entries().stream()
                .filter(header -> !CONTENT_LENGTH_KEY.equals(header.getKey()))
                .map(entry -> new BasicHeader(entry.getKey(), entry.getValue()))
                .toArray(org.apache.http.Header[]::new);
    }

    private URI adaptUrl(Request request) throws IOException {
        try {
            URIBuilder uriBuilder = new URIBuilder(request.url());
            QueryParameters queryParameters = request.queryParameters();
            for (QueryParameter queryParameter : queryParameters) {
                uriBuilder.addParameter(queryParameter.key, queryParameter.value);
            }
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new IOException(format("Invalid url '%s'", request.url()), e);
        }
    }

    private static class GenericHttpUriRequest extends HttpEntityEnclosingRequestBase {

        private final String methodName;

        GenericHttpUriRequest(String methodName, URI uri, RequestConfig requestConfig) {
            this.methodName = methodName;
            setURI(uri);
            setConfig(requestConfig);
        }

        @Override
        public String getMethod() {
            return methodName;
        }
    }
}
