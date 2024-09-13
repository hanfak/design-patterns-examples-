package pluginarch.plugins;

import pluginarch.Plugin;

public class Bad1Plugin implements Plugin {
    @Override
    public String getName() {
        return "Bad1 Plugin";
    }

    @Override
    public void execute() {
        System.out.println("This issssss bad!");
    }
}