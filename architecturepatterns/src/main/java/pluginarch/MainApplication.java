package pluginarch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import static pluginarch.JarCreator.createJars;

public class MainApplication {
    private static PluginLoader pluginLoader;
    private static List<Plugin> plugins;

    public static void main(String[] args) {
        try {
            createJars();

            // Load plugins
            String pluginsDir = "architecturepatterns/src/main/java/pluginarch/plugins";  // Directory where plugins (JARs) are located
            pluginLoader = new PluginLoader(pluginsDir);
            plugins = pluginLoader.loadPlugins();

            if (plugins.isEmpty()) {
                System.out.println("No plugins found.");
                return;
            }

            // Start command-line menu
            runMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to run the menu and handle dynamic updates
    private static void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            refreshPlugins(); // Refresh the plugin list on every menu display

            // Display the menu
            System.out.println("\nAvailable Plugins:");
            for (int i = 0; i < plugins.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, plugins.get(i).getName());
            }
            System.out.println("0. Quit");
            System.out.print("Choose a plugin to run: ");

            // Get user input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Clear invalid input
            }

            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice > 0 && choice <= plugins.size()) {
                // Run the selected plugin
                Plugin selectedPlugin = plugins.get(choice - 1);
                System.out.printf("Running%n%n%s...\n" + System.lineSeparator().repeat(2), selectedPlugin.getName());
                selectedPlugin.execute();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // Function to periodically refresh the plugins list if new ones are added
    private static void refreshPlugins() {
        try {
            List<Plugin> newPlugins = pluginLoader.loadPlugins();

            // Check if there are any new plugins
            if (newPlugins.size() > plugins.size()) {
                System.out.println("New plugins detected, refreshing the plugin list...");
                plugins = newPlugins;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
