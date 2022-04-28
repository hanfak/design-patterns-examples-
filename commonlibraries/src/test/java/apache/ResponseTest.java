package apache;


import commonlibraries.httpclient.apache.examples.WithExamples;
import org.junit.Test;

public class ResponseTest implements WithAssertions, WithExamples {

    @Test
    public void modifyReturnsABuilderThatBuildsIntoTheSameResponse() throws Exception {
        Response response = new ResponseBuilder()
                .protocol("HTTP/1.1")
                .header("Cache-Control", "no-cache")
                .body("I am a body")
                .statusCode(123)
                .build();

        assertThat(response.modify().build()).isEqualTo(response);
    }

    @Test
    public void successfulResponsesAreBetween200And299() throws Exception {
        assertThat(responseWithStatusCode(199)).isNotSuccessful();
        assertThat(responseWithStatusCode(200)).isSuccessful();
        assertThat(responseWithStatusCode(299)).isSuccessful();
        assertThat(responseWithStatusCode(300)).isNotSuccessful();
    }
}