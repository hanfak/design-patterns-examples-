package apache;

import org.junit.Test;

public class RequestTest implements WithAssertions {

    @Test
    public void modifyReturnsABuilderThatBuildsIntoTheSameRequest() throws Exception {
        Request request = new RequestBuilder()
                .method("POST")
                .url("http://localhost:8080/hydra")
                .header("Cache-Control", "no-cache")
                .queryParameter("a", "b")
                .queryParameter("c", "d")
                .body("body")
                .build();

        assertThat(request.modify().build()).isEqualTo(request);
    }
}