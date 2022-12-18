package testing.lsd;

import com.lsd.LsdContext;
import com.lsd.events.ArrowType;
import com.lsd.events.Message;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CustomLsdExtension.class)
@DisplayName("Hello")
public class Example03Test implements WithAssertions {

    @Test
    void shouldDoThis() {
        givenThatthis("hello");
            whenWeDoThat();
        thenWeGetThis();

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
        LsdContext.getInstance().capture("A Request from A to C", "Some details"); // Can use static custom renderer around body
    }
}
