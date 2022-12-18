package testing.lsd;

import com.lsd.LsdContext;
import com.lsd.events.ArrowType;
import com.lsd.events.Message;
import io.lsdconsulting.junit5.LsdExtension;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(LsdExtension.class)
@DisplayName("Hello")
public class Example02Test implements WithAssertions {

    @Test
    void shouldDoThis() {
        givenThatthis("hello");
        whenWeDoThat();
        thenWeGetThis();
    }

    @Test
    @DisplayName("This is the name of feature")
    void shouldDoFail() {
        givenThatthis("hello");
        whenWeDoThat();
        thenWeGetThis1();
    }

    @ParameterizedTest
    @ValueSource(strings = {"apple", "berry", "cat"})
    void aParameterisedTest(String input) {
        LsdContext.getInstance().capture("a package from A to B", input);
        assertThat(List.of("apple", "berry", "cat")).contains(input);
    }

    private void thenWeGetThis1() {
        assertTrue(false);
        sequenceDiagram(); // Does not get rendered if test fails
    }

    private void thenWeGetThis() {
        sequenceDiagram();
    }

    private void whenWeDoThat() {
        LsdContext.getInstance().capture("Hello", "Blah");
    }

    private void givenThatthis(String hello) {
        LsdContext.getInstance().addFact("hello","given");
    }

    private void sequenceDiagram() {
        Message message = Message.builder()
                .from("A")
                .to("B")
                .data("description")
                .label("description")
                .id(LsdContext.getInstance().getIdGenerator().next())
                .arrowType(ArrowType.SOLID)
                .build();
        Message message2 = Message.builder()
                .from("B")
                .to("B")
                .data("description")
                .label("description")
                .id(LsdContext.getInstance().getIdGenerator().next())
                .arrowType(ArrowType.SOLID)
                .build();
        Message message3 = Message.builder()
                .from("B")
                .to("A")
                .data("description")
                .label("description")
                .id(LsdContext.getInstance().getIdGenerator().next())
                .arrowType(ArrowType.SOLID)
                .build();
        LsdContext.getInstance().capture(message);
        LsdContext.getInstance().capture(message2);
        LsdContext.getInstance().capture(message3);
    }
}
