package commonlibraries.httpclient.apache;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

public class HeadersTest implements WithAssertions {

    @Test
    public void asMapReturnsMapRepresentationOfHeaders() {
        ArrayListMultimap<String, String> headerMap = ArrayListMultimap.create();
        headerMap.put("key", "value");

        Headers headers = new Headers(headerMap);

        assertThat(headers.asMultiMap()).isEqualTo(headerMap);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void asMapReturnsUnmodifiableMap() {
        Headers headers = new Headers(ArrayListMultimap.create());

        Multimap<String, String> headerMap = headers.asMultiMap();
        headerMap.put("key", "value");
    }
}