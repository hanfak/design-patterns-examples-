package pluginarch;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PluginLoader {
    private final String pluginsDir;
    private static final Set<String> loadedPlugins = new HashSet<>();
    private static final List<Plugin> plugins = new ArrayList<>();

    public PluginLoader(String pluginsDir) {
        this.pluginsDir = pluginsDir;
    }

    public List<Plugin> loadPlugins() throws Exception {
        File jarDir = new File(pluginsDir);
        if (!jarDir.exists()) {
            throw new IllegalArgumentException("Invalid plugin directory: " + pluginsDir);
        }

        File[] jarFiles = jarDir.listFiles((dir, name) -> name.endsWith(".jar"));
        if (jarFiles == null || jarFiles.length == 0) {
            return plugins;
        }
        // TODO: 13/09/2024 update after removing plugins
        for (File jarFile : jarFiles) {
            if (!loadedPlugins.contains(jarFile.getName())) {
                var pluginInstance = loadPluginFromJar(jarFile);
                if (pluginInstance instanceof Plugin) {
                    plugins.add(((Plugin) pluginInstance));
                    loadedPlugins.add(jarFile.getName());
                }
            }
        }

        return plugins;
    }


    // Method to load the plugin class dynamically from the JAR using the Main-Class from the manifest
    private static Object loadPluginFromJar(File jarFile) throws IOException, ReflectiveOperationException {
        // Open the JAR file and read the manifest
        try (JarFile jar = new JarFile(jarFile)) {
            Manifest manifest = jar.getManifest();
            Attributes attributes = manifest.getMainAttributes();

            // Get the fully qualified class name of the plugin from the manifest's Main-Class attribute
            String mainClassName = attributes.getValue(Attributes.Name.MAIN_CLASS);

            if (mainClassName == null || mainClassName.isEmpty()) {
                System.out.println("Main-Class not found in JAR manifest: " + jarFile.getName());
                return null;
            }

            // Dynamically load the class using URLClassLoader
            URL[] urls = {jarFile.toURI().toURL()};
            try (URLClassLoader classLoader = new URLClassLoader(urls, PluginLoader.class.getClassLoader())) {
                Class<?> pluginClass = classLoader.loadClass(mainClassName);
                var pluginInstance = pluginClass.getDeclaredConstructor().newInstance();
                System.out.println("Loaded plugin: " + pluginInstance.getClass()
                        .getName());
                return pluginInstance;
            }
        }
    }
}