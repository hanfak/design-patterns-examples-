package nullobject.exampleone;

import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String[] args) {
    Message highPriorityMsg = new Message("Alert!", "high");
    Message mediumPriorityMsg = new Message("Warning!", "medium");
    Message lowPriorityMsg = new Message("Take a look!", "low");
    Message nullPriorityMsg = new Message("Take a look!", null);

    List<Message> messages = Arrays.asList(highPriorityMsg,
            mediumPriorityMsg,
            lowPriorityMsg,
            nullPriorityMsg);

    RoutingHandler routingHandler = new RoutingHandler();
    routingHandler.handle(messages);

  }

}
