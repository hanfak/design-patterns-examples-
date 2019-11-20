package effectivejava.singleton;

// Old way of creating singleton
// Will need to implement serializable to make sure same instance is returned
public class Singleton {
  private static final Singleton INSTANCE = new Singleton();

  // To prevent new instances created
  private  Singleton() {
  }

  // Singleton should not inherit from another class
}
