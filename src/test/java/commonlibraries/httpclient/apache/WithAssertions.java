package commonlibraries.httpclient.apache;


public interface WithAssertions extends org.assertj.core.api.WithAssertions {
    default ThenTheTestResponse assertThat(TestResponse response) {
        return new ThenTheTestResponse(response);
    }

    default ThenTheResponse assertThat(Response response) {
        return new ThenTheResponse(response);
    }

    default ThenTheRequest assertThat(Request request) {
        return new ThenTheRequest(request);
    }
}
