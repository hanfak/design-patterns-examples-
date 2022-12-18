package testing.junit5.annotations.parameters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class Example01Test implements WithAssertions {
    @ParameterizedTest
    @ValueSource(strings = {"apple", "berry", "cat"})
    void aParameterisedTest(String input) {
//        LsdContext.getInstance().capture("a package from A to B", input);
        assertThat(List.of("apple", "berry", "cat")).contains(input);
    }

}
