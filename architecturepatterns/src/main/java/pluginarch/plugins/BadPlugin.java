package pluginarch.plugins;

import pluginarch.Plugin;

public class BadPlugin implements Plugin {
    @Override
    public String getName() {
        return "Bad Plugin";
    }

    @Override
    public void execute() {
        System.out.println("This is bad!");
    }
}