package integrations.messaging.example02;

public class SubscriberImpl extends Subscriber{
  //Add/registers subscriber with PubSubService for a topic
  public void addSubscriber(Topic topic, PubSubService pubSubService){
    pubSubService.addSubscriber(topic, this);
  }

  //Removes/Unsubscribe subscriber with PubSubService for a topic
  public void unSubscribe(Topic topic, PubSubService pubSubService){
    pubSubService.removeSubscriber(topic, this);
  }

  //Request specifically for messages related to topic from PubSubService
  public void getMessagesForSubscriberOfTopic(Topic topic, PubSubService pubSubService) {
    pubSubService.getMessagesForSubscriberOfTopic(topic, this);

  }
}