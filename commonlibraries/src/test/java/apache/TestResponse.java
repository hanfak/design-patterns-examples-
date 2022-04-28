package apache;

import commonlibraries.httpclient.apache.Response;

public class TestResponse extends Response {

    private long responseTime;

    public TestResponse(Response response, long responseTime) {
        super(response.body(), response.statusCode(), response.protocol(), response.headers());
        this.responseTime = responseTime;
    }

    public long responseTime() {
        return responseTime;
    }
}
