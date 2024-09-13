package pluginarch.plugins;

import pluginarch.Plugin;

public class HelloPlugin implements Plugin {
    @Override
    public String getName() {
        return "Hello Plugin";
    }

    @Override
    public void execute() {
        System.out.println("Hello from the plugin!");
    }
}