package generics.example01;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Ex01RawTypesTest implements WithAssertions {
    @Test
    public void rawTypes() throws Exception {
        List list = new ArrayList();
        list.add(2);
        list.add("string");
        Object o1 = list.get(0);
        Object o2 = list.get(1);
        Integer v1 = (Integer) list.get(0);
        String v2 = (String) list.get(1);
    }

}