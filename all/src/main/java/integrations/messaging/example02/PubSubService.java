package integrations.messaging.example02;

import java.util.*;

//the task of servicing the Subscribers to the messaging infrastructure
// acts like a middleman between Publishers and receivers.
// Also known as a broker
public class PubSubService {
  //Keeps set of subscribers interested in a topic, using set to prevent duplicates
  private final Map<Topic, Set<Subscriber>> subscribersTopicMap = new HashMap<>();

  //Holds messages published by publishers
  private final Queue<Message> messagesQueue = new LinkedList<>();

  //Adds message sent by publisher to queue
  public void addMessageToQueue(Message message) {
    messagesQueue.add(message);
  }

  //Add a new Subscriber for a topic
  public void addSubscriber(Topic topic, Subscriber subscriber) {
    Set<Subscriber> subscribers = new HashSet<>();

    if (subscribersTopicMap.containsKey(topic)) {
      subscribers = subscribersTopicMap.get(topic);
      subscribers.add(subscriber);
      subscribersTopicMap.put(topic, subscribers);
    } else {
      subscribers.add(subscriber);
      subscribersTopicMap.put(topic, subscribers);
    }
  }

  //Remove an existing subscriber for a topic
  public void removeSubscriber(Topic topic, Subscriber subscriber) {
    if (subscribersTopicMap.containsKey(topic)) {
      Set<Subscriber> subscribers = subscribersTopicMap.get(topic);
      subscribers.remove(subscriber);
      subscribersTopicMap.put(topic, subscribers);
    }
  }

  //Broadcast new messages added in queue to All subscribers of the topic.
  // messagesQueue will be empty after broadcasting and
  // all subscribers have received the message from the topics it has registered with
  // This can be called on cron job, or as soon as a message is added/published to the queue
  public void broadcast() {
    if (messagesQueue.isEmpty()) {
      System.out.println("No messages from publishers to display");
    } else {
      while (!messagesQueue.isEmpty()) {
        Message message = messagesQueue.remove();
        Set<Subscriber> subscribersOfTopic = subscribersTopicMap.get(message.getTopic());

        for (Subscriber subscriber : subscribersOfTopic) {
          addMessageToSubscriber(message, subscriber);
        }
      }
    }
  }

  //Sends messages about a topic for subscriber at any point
  // This can be called on cron job, or as soon as a message is added/published to the queue for the topic
  public void getMessagesForSubscriberOfTopic(Topic topic, Subscriber subscriber) {
    if (messagesQueue.isEmpty()) {
      System.out.println("No messages from publishers to display");
    } else {
      while (!messagesQueue.isEmpty()) {
        Message message = messagesQueue.remove();

        if (Objects.equals(message.getTopic(), topic)) {

          Set<Subscriber> subscribersOfTopic = subscribersTopicMap.get(topic);

          for (Subscriber subscriberOfTopic : subscribersOfTopic) {
            if (subscriberOfTopic.equals(subscriber)) {
              addMessageToSubscriber(message, subscriber);
            }
          }
        } else {
          messagesQueue.add(message);
        }
      }
    }
  }

  private void addMessageToSubscriber(Message message, Subscriber subscriber) {
    //add broadcasted message to subscribers message queue
    List<Message> subscriberMessages = subscriber.getSubscriberMessages();
    subscriberMessages.add(message);

    subscriber.setSubscriberMessages(subscriberMessages);
  }
}