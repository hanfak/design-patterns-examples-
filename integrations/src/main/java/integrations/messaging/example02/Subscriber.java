package integrations.messaging.example02;

import java.util.ArrayList;
import java.util.List;

//the entities who subscribe to messages on a topic.
// All get those messages from a topic, that has been published to the broker/service
public abstract class Subscriber {
  //store all messages received by the subscriber
  private List<Message> subscriberMessages = new ArrayList<>();

  public List<Message> getSubscriberMessages() {
    return subscriberMessages;
  }

  public void setSubscriberMessages(List<Message> subscriberMessages) {
    this.subscriberMessages = subscriberMessages;
  }

  //Add subscriber with PubSubService for a topic
  //registers itself with PubSubService (middleman) and tells that it’s interested in messages related to a particular topic.
  public abstract void addSubscriber(Topic topic, PubSubService pubSubService);

  //Unsubscribe subscriber with PubSubService for a topic
  public abstract void unSubscribe(Topic topic, PubSubService pubSubService);

  //Request specifically for messages related to topic from PubSubService
  public abstract void getMessagesForSubscriberOfTopic(Topic topic, PubSubService pubSubService);

  //Print all messages received by the subscriber
  public void printMessages() {
    for (Message message : subscriberMessages) {
      System.out.println("Message Topic -> " + message.getTopic() + " : " + message.getPayload());
    }
  }
}
