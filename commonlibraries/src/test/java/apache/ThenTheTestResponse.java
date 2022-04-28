package apache;


import static org.assertj.core.api.Assertions.assertThat;

public class ThenTheTestResponse extends AbstractThenTheResponse<ThenTheTestResponse, TestResponse> {

    public ThenTheTestResponse(TestResponse response) {
        super(response, ThenTheTestResponse.class);
    }

    public ThenTheTestResponse hasComesBackInNoMoreThanMilliseconds(long maximumResponseTime) {
        assertThat(response.responseTime()).isLessThan(maximumResponseTime);
        return myself;
    }
}
