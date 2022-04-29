package integrations.messaging.example02;

// Entity sent by the publisher to a service/broker
public class Message {

  private final Topic topic;
  private final String payload;


  public Message(Topic topic, String payload) {
    this.topic = topic;
    this.payload = payload;
  }

  public Topic getTopic() {
    return topic;
  }

  public String getPayload() {
    return payload;
  }
}
