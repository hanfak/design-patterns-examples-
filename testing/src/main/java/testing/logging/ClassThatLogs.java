package testing.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassThatLogs {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassThatLogs.class);

    public void doSomething(boolean logErrors) {
        LOGGER.debug("The boolean passed in has value {}", logErrors);
        if (logErrors) {
            LOGGER.error("this is because there's a boolean=true");
        }
        LOGGER.info("this is happening no matter what");
    }

}
