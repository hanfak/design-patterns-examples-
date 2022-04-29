package apache.examples;


import apache.Request;
import apache.RequestBuilder;

public interface WithRequestExamples {

    default Request postWithBody(String body) {
        return new RequestBuilder().post().url("http://any/url").body(body).build();
    }
}
