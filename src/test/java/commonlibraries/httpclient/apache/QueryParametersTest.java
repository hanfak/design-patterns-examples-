package commonlibraries.httpclient.apache;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.Collections;

public class QueryParametersTest implements WithAssertions {

    @Test
    public void noQueryParametersHasEmptyToString() {
        assertThat(new QueryParameters(Collections.emptyMap())).hasToString("");
    }
}