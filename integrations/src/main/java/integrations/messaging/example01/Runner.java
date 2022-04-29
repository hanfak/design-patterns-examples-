package integrations.messaging.example01;

public class Runner {
  public static void main(String[] args) throws InterruptedException {
    QuoteSource source = new QuoteSource();
    Publisher<String> publisher = new Publisher<>(source);

    Thread t = new Thread(publisher);
    t.start();
    new Subscriber<>("Subscriber-1", "Quote_1", publisher);
    new Subscriber<>("Subscriber-2", "Quote_2", publisher);

    Thread.currentThread().join(60*1000);
    System.exit(0);
  }
}
