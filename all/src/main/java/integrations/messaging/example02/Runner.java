package integrations.messaging.example02;

public class Runner {

  // topic based Publish-Subscribe pattern,
  // Publishers tag each message with the a topic instead of referencing specific Subscribers.
  // Messaging system then sends the message to all Subscribers who have asked to receive messages on that topic.
  public static void main(String[] args) {
    //Instantiate publishers, subscribers and PubSubService
    Publisher javaPublisher = new PublisherImpl();
    Publisher pythonPublisher = new PublisherImpl();

    Subscriber javaSubscriber = new SubscriberImpl();
    Subscriber allLanguagesSubscriber = new SubscriberImpl();
    Subscriber pythonSubscriber = new SubscriberImpl();

    PubSubService pubSubService = new PubSubService();

    //Declare Messages and Publish Messages to PubSubService
    Message javaMsg1 = new Message(new Topic("Java"), "Core Java Concepts");
    Message javaMsg2 = new Message(new Topic("Java"), "Spring MVC : Dependency Injection and AOP");
    Message javaMsg3 = new Message(new Topic("Java"), "JPA & Hibernate");

    javaPublisher.publish(javaMsg1, pubSubService);
    javaPublisher.publish(javaMsg2, pubSubService);
    javaPublisher.publish(javaMsg3, pubSubService);

    Message pythonMsg1 = new Message(new Topic("Python"), "Easy and Powerful programming language");
    Message pythonMsg2 = new Message(new Topic("Python"), "Advanced Python message");

    pythonPublisher.publish(pythonMsg1, pubSubService);
    pythonPublisher.publish(pythonMsg2, pubSubService);

    //Declare Subscribers
    javaSubscriber.addSubscriber(new Topic("Java"),pubSubService);		//Java subscriber only subscribes to Java topics
    pythonSubscriber.addSubscriber(new Topic("Python"),pubSubService);   //Python subscriber only subscribes to Python topics
    allLanguagesSubscriber.addSubscriber(new Topic("Java"), pubSubService);	//all subscriber, subscribes to both Java and Python
    allLanguagesSubscriber.addSubscriber(new Topic("Python"), pubSubService);

    //Trying unSubscribing a subscriber
    //pythonSubscriber.unSubscribe(new Topic("Python"), pubSubService);

    //Broadcast message to all subscribers. After broadcast, messageQueue will be empty in PubSubService
    pubSubService.broadcast();

    //Print messages of each subscriber to see which messages they got
    System.out.println("Messages of Java Subscriber are: ");
    javaSubscriber.printMessages();

    System.out.println("\nMessages of Python Subscriber are: ");
    pythonSubscriber.printMessages();
  }
}
