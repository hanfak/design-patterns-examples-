package integrations.messaging.example02;
// the entities who create/publish a message on a topic
// Publishers only concern themselves with creating the original message
public interface Publisher {
  //Publishes new message to PubSubService
  // It does not know who it will send the message to
  void publish(Message message, PubSubService pubSubService);
}
