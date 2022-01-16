package dependencyinjection.crosscutting.better;

public class Consumer {

    public String execute() {
        return "The time is " + SystemDateFactory.now();
    }
}
