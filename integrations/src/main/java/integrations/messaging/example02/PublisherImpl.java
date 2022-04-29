package integrations.messaging.example02;

public class PublisherImpl implements Publisher {
  //Publishes new message to PubSubService
  public void publish(Message message, PubSubService pubSubService) {
    pubSubService.addMessageToQueue(message);
  }
}
