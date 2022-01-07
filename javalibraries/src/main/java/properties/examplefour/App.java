package properties.examplefour;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static java.lang.String.format;

public class App {

  public static void main(String... args) throws IOException {
    Path appProperties = Paths.get("target/classes/config.properties");
    Path secretProperties = Paths.get("target/classes/secrets.properties");
    
    Properties properties = new Properties();
    try (FileInputStream propertiesFileStream = new FileInputStream(appProperties.toFile())) {
      properties.load(propertiesFileStream);
    } catch (IOException e) {
      throw new IllegalStateException(format("Could not find application properties at '%s'", appProperties), e);
    }

    System.out.println("size: " + properties.size());
    try (FileInputStream propertiesFileStream = new FileInputStream(secretProperties.toFile())) {
      properties.load(propertiesFileStream);
    } catch (IOException e) {
      throw new IllegalStateException(format("Problem loading '%s'", secretProperties), e);
    }
    System.out.println("size: " + properties.size());

    String user = properties.getProperty("user");
    System.out.println("version = " + user);
    System.out.println(properties.getProperty("password.two"));
    String pass = properties.getProperty("password");
    System.out.println("applicationName = " + pass);
  }
}
