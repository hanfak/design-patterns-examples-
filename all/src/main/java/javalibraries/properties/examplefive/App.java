package javalibraries.properties.examplefive;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class App {
  public static void main(String... args) throws IOException {
    Properties properties = new Properties();
    properties.setProperty("user", "Han");
    properties.store(new FileWriter("src/main/resources/properties/newApp.properties"),  "store to properties file");
  }
}
