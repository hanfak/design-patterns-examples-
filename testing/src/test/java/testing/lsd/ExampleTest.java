package testing.lsd;

import com.lsd.LsdContext;
import com.lsd.events.ArrowType;
import com.lsd.events.Message;
import com.lsd.events.ShortMessageInbound;
import org.junit.jupiter.api.Test;

import static com.lsd.OutcomeStatus.SUCCESS;
import static com.lsd.events.ArrowType.BI_DIRECTIONAL;
import static com.lsd.events.ShortMessageInbound.builder;

public class ExampleTest {
    LsdContext lsdContext = LsdContext.getInstance();

    @Test
    void shouldDoThis() {
//        lsdContext.capture(builder().id("id1")
//                .to("A").label("in").data("start some job").build());
        Message message = Message.builder()
                .from("A")
                .to("B")
                .data("description")
                .label("description")
                .id("1")
                .arrowType(ArrowType.SOLID)
                .build();
        Message message2 = Message.builder()
                .from("B")
                .to("B")
                .data("description")
                .label("description")
                .id("2")
                .arrowType(ArrowType.SOLID)
                .build();
        Message message3 = Message.builder()
                .from("B")
                .to("A")
                .data("description")
                .label("description")
                .id("3")
                .arrowType(ArrowType.SOLID)
                .build();
        lsdContext.capture(message);
        lsdContext.capture(message2);
        lsdContext.capture(message3);
        lsdContext.addFact("Something to highlight", "description");
        lsdContext.completeScenario("A Scenario Title",
                "The sceenario description goes here and may contain html", SUCCESS);
        lsdContext.completeReport("My Report Title");
    }

    @Test
    void shouldDoThis1() {
//        lsdContext.capture(builder().id("id1")
//                .to("A").label("in").data("start some job").build());
        Message message = Message.builder()
                .from("A")
                .to("B")
                .data("description")
                .label("description")
                .id("1a")
                .arrowType(ArrowType.SOLID)
                .build();
        Message message2 = Message.builder()
                .from("B")
                .to("B")
                .data("description")
                .label("description")
                .id("2a")
                .arrowType(ArrowType.SOLID)
                .build();
        Message message3 = Message.builder()
                .from("B")
                .to("A")
                .data("description")
                .label("description")
                .id("3a")
                .arrowType(ArrowType.SOLID)
                .build();
        lsdContext.capture(message);
        lsdContext.capture(message2);
        lsdContext.capture(message3);
        lsdContext.addFact("Something to highlight", "description");
        lsdContext.completeScenario("A Scenario Title 1",
                "The sceenario description goes here and may contain html", SUCCESS);
        lsdContext.completeReport("My Report Title 2");
    }

}
