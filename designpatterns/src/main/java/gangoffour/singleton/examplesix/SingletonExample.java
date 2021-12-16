package gangoffour.singleton.examplesix;

import java.io.Serializable;

public class SingletonExample implements Serializable {

  // Static member holds only one instance of the
  // SingletonExample class
  private static final SingletonExample singletonInstance =
          new SingletonExample();

  // SingletonExample prevents any other class from instantiating
  private SingletonExample() {
  }

  // Providing Global point of access
  public static SingletonExample getSingletonInstance() {
    return singletonInstance;
  }
  // This method is called immediately after an object of this class is deserialized.
  protected Object readResolve() {
  // Instead of the object we’re on, return the class variable singleton
    return singletonInstance;
  }
}