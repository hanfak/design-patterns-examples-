package gangoffour.singleton.examplethree;

// Eager initialization
public class SingletonExample {
  // Static member holds only one instance of the
  // SingletonExample class
  private static SingletonExample singletonInstance;

  // SingletonExample prevents any other class from instantiating
  private SingletonExample() {
  }

  // Providing Global point of access
  public static SingletonExample getSingletonInstance() {
    return singletonInstance;
  }
}
