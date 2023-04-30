package gangoffour.command.commanddispatcher.example1;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcherExample {

    public static void main(String[] args) {
        var document = documentFactory();
        var dispatcher = new CommandDispatcher();

        // Register commands
        dispatcher.registerCommand("save", new SaveCommand(document));
        dispatcher.registerCommand("print", new PrintCommand(document));

        // Dispatch commands
        dispatcher.dispatch("save"); // Saves the document
        dispatcher.dispatch("print"); // Prints the document
    }

    private static Document documentFactory() {
        return new Document() {

            @Override
            public void print() {}

            @Override
            public void save() {}
        };
    }
}

interface Command {

    void execute();
}

// Concrete command classes
class SaveCommand implements Command {

    private final Document document;

    public SaveCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.save();
    }
}

class PrintCommand implements Command {

    private final Document document;

    public PrintCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.print();
    }
}

// Command dispatcher
class CommandDispatcher {

    private final Map<String, Command> commands = new HashMap<>();

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void dispatch(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        }
    }
}

interface Document {
    void print();
    void save();
}

