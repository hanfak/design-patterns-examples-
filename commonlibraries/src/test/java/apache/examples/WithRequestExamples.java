package apache.examples;


import commonlibraries.httpclient.apache.Request;
import commonlibraries.httpclient.apache.RequestBuilder;

public interface WithRequestExamples {

    default Request postWithBody(String body) {
        return new RequestBuilder().post().url("http://any/url").body(body).build();
    }
}
