package designpatterns.gangoffour.singleton.exampletwo;

// Lazy initialization with Double check locking
public class SingletonExample {
  // Static member holds only one instance of the
  // SingletonExample class
  private static volatile SingletonExample singletonInstance;

  // SingletonExample prevents any other class from instantiating
  private SingletonExample() {
  }

  public static SingletonExample getSingletonInstance() {
    if (null == singletonInstance) {
      synchronized (SingletonExample.class){
        if (null == singletonInstance) {
          singletonInstance = new SingletonExample();
        }
      }
    }
    return singletonInstance;
  }
}
