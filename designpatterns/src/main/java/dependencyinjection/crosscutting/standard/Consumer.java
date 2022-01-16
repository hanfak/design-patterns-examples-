package dependencyinjection.crosscutting.standard;

import java.time.LocalDateTime;

public class Consumer {
    private final SystemDate systemDate;

    public Consumer(SystemDate systemDate) {
        this.systemDate = systemDate;
    }

    public String execute() {
        return "The time is " + systemDate.now();
    }
}
