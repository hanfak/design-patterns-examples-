package pluginarch;

public interface Plugin {
    String getName();
    void execute();
    // Method to set the base plugin (optional)
    default void setBasePlugin(Plugin basePlugin) {
        // Default implementation does nothing, can be overridden
    }
}

