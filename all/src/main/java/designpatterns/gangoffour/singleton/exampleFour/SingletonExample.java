package designpatterns.gangoffour.singleton.exampleFour;

import java.io.IOException;

// Static block initialization
public class SingletonExample {
  // Static member holds only one instance of the
  // SingletonExample class
  private static SingletonExample singletonInstance;

  static {
    try {
      singletonInstance = new SingletonExample();
    } catch (IOException e) {
      throw new RuntimeException("Darn, an error occurred!", e);
    }
  }
  // SingletonExample prevents any other class from instantiating
  private SingletonExample() throws IOException {
  }

  // Providing Global point of access
  public static SingletonExample getSingletonInstance() {
    return singletonInstance;
  }
}
