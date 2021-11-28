package javalibraries.properties.exampleone;

import javalibraries.properties.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {

  public static void main(String... args) throws IOException {
    Utils utils = new Utils();
    File file = utils.getResourceFile("config.properties");

    FileInputStream fin = new FileInputStream(file);

    Properties properties = new Properties();
    properties.load(fin);

    String version = properties.getProperty("user");
    System.out.println("version = " + version);
    String applicationName = properties.getProperty("password");
    System.out.println("applicationName = " + applicationName);
  }
}
