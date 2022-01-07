package properties.examplethree;

import java.util.Properties;

public class App {
  public static void main(String... args) {
    Properties properties = new Properties();
    properties.put("url", "http:/blah.com");
    System.out.println(properties.getProperty("url"));
    System.out.println("size: " + properties.size());
    properties.setProperty("random", "booboo");
    System.out.println("added prop: " + properties.getProperty("random"));
    System.out.println("default prop if not there: " + properties.getOrDefault("hello", "default"));
    System.out.println("size: " + properties.size());

  }
}
