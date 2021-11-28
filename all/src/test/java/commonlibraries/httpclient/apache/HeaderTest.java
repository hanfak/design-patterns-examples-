package commonlibraries.httpclient.apache;

import org.junit.Test;

import java.util.Arrays;

public class HeaderTest implements WithAssertions {

    @Test
    public void multipleValuesForTheSameKeyAreCommaSeparated() {
        Header header = new Header("key", Arrays.asList("value1", "value2"));

        assertThat(header.value).isEqualTo("value1,value2");
    }

    @Test
    public void toStringIsKeyColonValue() {
        Header header = new Header("key", "value");

        assertThat(header).hasToString("key: value");
    }
}