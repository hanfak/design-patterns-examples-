package javalibraries.properties;

import java.io.File;

public class Utils {
  public File getResourceFile(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    return new File(classLoader.getResource(fileName).getFile());
  }
}
