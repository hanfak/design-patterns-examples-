package testing.logging.memoryappender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BusinessWorker {
    private static Logger logger = LoggerFactory.getLogger(BusinessWorker.class);

    public void generateLogs(String msg) {

        logger.trace(msg);
        logger.debug(msg);
        logger.info(msg);
        logger.warn(msg);
        logger.error(msg);
    }

    public static void main(String... args) {
        new BusinessWorker().generateLogs("Hello");
    }
}
