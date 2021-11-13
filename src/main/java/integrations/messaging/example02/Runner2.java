package integrations.messaging.example02;

public class Runner2 {

  // topic based Publish-Subscribe pattern,
  // Publishers tag each message with the a topic instead of referencing specific Subscribers.
  // Messaging system then sends the message to all Subscribers who have asked to receive messages on that topic.
  public static void main(String[] args) {
    //Instantiate publishers, subscribers and PubSubService
    Publisher javaPublisher = new PublisherImpl();

    Subscriber javaSubscriber = new SubscriberImpl();
    Subscriber allLanguagesSubscriber = new SubscriberImpl();
    Subscriber pythonSubscriber = new SubscriberImpl();

    PubSubService pubSubService = new PubSubService();

    //Declare Subscribers
    javaSubscriber.addSubscriber(new Topic("Java"),pubSubService);		//Java subscriber only subscribes to Java topics
    pythonSubscriber.addSubscriber(new Topic("Python"),pubSubService);   //Python subscriber only subscribes to Python topics
    allLanguagesSubscriber.addSubscriber(new Topic("Java"), pubSubService);	//all subscriber, subscribes to both Java and Python
    allLanguagesSubscriber.addSubscriber(new Topic("Python"), pubSubService);

    System.out.println("\nPublishing 2 more Java Messages...");
    Message javaMsg4 = new Message(new Topic("Java"), "JSP and Servlets");
    Message javaMsg5 = new Message(new Topic("Java"), "Struts framework");

    javaPublisher.publish(javaMsg4, pubSubService);
    javaPublisher.publish(javaMsg5, pubSubService);

    javaSubscriber.getMessagesForSubscriberOfTopic(new Topic("Java"), pubSubService);
    System.out.println("\nMessages of Java Subscriber now are: ");
    javaSubscriber.printMessages();

    System.out.println("\n*****\n");
    pythonSubscriber.getMessagesForSubscriberOfTopic(new Topic("Python"), pubSubService);
    System.out.println("\nMessages of python Subscriber now are: ");
    pythonSubscriber.printMessages();

    System.out.println("\n*****\n");
    allLanguagesSubscriber.getMessagesForSubscriberOfTopic(new Topic("Java"), pubSubService);
    System.out.println("\nMessages of All Languages Subscriber are: ");
    allLanguagesSubscriber.printMessages();
  }
}
