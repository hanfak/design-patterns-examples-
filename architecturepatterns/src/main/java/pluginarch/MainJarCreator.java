package pluginarch;

import static pluginarch.JarCreator.createJars;

public class MainJarCreator {
    public static void main(String... args) {
        String pluginsDir = "architecturepatterns/src/main/java/pluginarch/plugins";  // Directory where plugins (JARs) are located

        createJars();
    }
}
