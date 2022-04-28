package apache;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import org.junit.After;


public class WireMockTest implements WithAssertions {
    protected void givenThat(MappingBuilder MappingBuilder) {
        WiremockContainer.register(MappingBuilder);
    }

    protected void verifyThat(int times, RequestPatternBuilder requestPatternBuilder) {
        WiremockContainer.verifyThat(times, requestPatternBuilder);
    }

    protected void verifyThat(RequestPatternBuilder requestPatternBuilder) {
        WiremockContainer.verifyThat(requestPatternBuilder);
    }

    protected String baseUrl() {
        return WiremockContainer.wiremockBaseUrl();
    }

    @After
    public void tearDown() {
        WiremockContainer.resetMappings();
    }
}
