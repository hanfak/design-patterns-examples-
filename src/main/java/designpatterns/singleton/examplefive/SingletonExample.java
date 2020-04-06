package designpatterns.singleton.examplefive;

// Initialization-on-demand holder idiom
//This solution leverages lazy initialization.
// Static instance field is initialized no earlier than SingletonHolder class is loaded and initialized.
// SingletonHolder class in its turn is loaded and initialized no earlier than it is first referenced.
// Finally SingletonHolder class is first referenced no earlier than getSingletonInstance() method is called.
public class SingletonExample {
  // Static member class member that holds only one instance of the
  // SingletonExample class
  private static class SingletonHolder{
    public static SingletonExample singletonInstance =
            new SingletonExample();
  }
  // SingletonExample prevents any other class from instantiating
  private SingletonExample() {
  }

  // Providing Global point of access
  public static SingletonExample getSingletonInstance() {
    return SingletonHolder.singletonInstance;
  }
}
