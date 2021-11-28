package designpatterns.gangoffour.factory.abstractfactory.examplethree;

public class App {

  /**
   * Application picks the factory type and creates it in run time (usually at
   * initialization stage), depending on the configuration or environment
   * variables.
   */
  private static Application configureApplication() {
    String osName = System.getProperty("os.name").toLowerCase();
    if (osName.contains("mac")) {
      return new Application(new MacOSFactory());
    } else {
      return  new Application(new WindowsFactory());
    }
  }

  public static void main(String[] args) {
    Application app = configureApplication();
    app.paint();
  }
}