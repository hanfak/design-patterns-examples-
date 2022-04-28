package apache;

import org.junit.Test;

import java.util.Arrays;

public class QueryParameterTest implements WithAssertions {

    @Test
    public void multipleValuesForTheSameKeyAreCommaSeparated() {
        QueryParameter queryParameter = new QueryParameter("key", Arrays.asList("value1", "value2"));

        assertThat(queryParameter.value).isEqualTo("value1,value2");
    }

    @Test
    public void toStringIsKeyEqualsValue() {
        QueryParameter queryParameter = new QueryParameter("key", "value");

        assertThat(queryParameter).hasToString("key=value");
    }
}