package testing.logging.memoryappender;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

// Wont work, due to different implements of slf4j on the class path
class BusinessWorkerTest {

    private static MemoryAppender memoryAppender;
    private static final String LOGGER_NAME = "BusinessWorker";
    private static final String MSG = "This is a test message!!!";

    @BeforeEach
    public void setup() {
        Logger logger = (Logger) LoggerFactory.getLogger(BusinessWorker.class);
        memoryAppender = new MemoryAppender();
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        logger.setLevel(Level.DEBUG);
        logger.addAppender(memoryAppender);
        memoryAppender.start();

    }

    @AfterEach
    public void cleanUp() {
        memoryAppender.reset();
        memoryAppender.stop();
    }

    @Test
    public void test() {
        BusinessWorker worker = new BusinessWorker();
        worker.generateLogs(MSG);

        // I check that I only have 4 messages (all but trace)
        assertThat(memoryAppender.countEventsForLogger(LOGGER_NAME)).isEqualTo(4);
        // I look for a specific message at a specific level, and I only have 1
        assertThat(memoryAppender.search(MSG, Level.INFO).size()).isEqualTo(1);
        // I check that the entry that is not present is the trace level
        assertThat(memoryAppender.contains(MSG, Level.TRACE)).isFalse();
    }
}