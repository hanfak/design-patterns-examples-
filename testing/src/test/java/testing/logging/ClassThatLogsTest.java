package testing.logging;


import com.github.valfirst.slf4jtest.TestLogger;
import com.github.valfirst.slf4jtest.TestLoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jext.Level;

import static com.github.valfirst.slf4jtest.Assertions.assertThat;
// http://projects.lidalia.org.uk/slf4j-test/
class ClassThatLogsTest {
    // Due to multiple impln of slf4j, there will be warnings
    private final TestLogger logger = TestLoggerFactory.getTestLogger(ClassThatLogs.class);
    private final ClassThatLogs sut = new ClassThatLogs();

    @AfterEach
    void tearDown() {
        logger.clear();
    }

    @Test
    void methodLogsErrorWhenBooleanIsTrue() {
        sut.doSomething(true);

        assertThat(logger).hasLogged(Level.ERROR, "this is because there's a boolean=true");
    }

    @Test
    void methodDoesNotLogErrorWhenBooleanIsFalse() {
        sut.doSomething(false);

        assertThat(logger).hasNotLogged(Level.ERROR, "this is because there's a boolean=true");
    }

    @Test
    void methodLogsInfoRegardless() {
        sut.doSomething(false);

        assertThat(logger).hasLogged(Level.INFO, "this is happening no matter what");
    }

    @Test
    void methodLogsFormatStringsInDebugMode() {
        sut.doSomething(false);

        assertThat(logger).hasLogged(Level.DEBUG, "The boolean passed in has value {}", false);
    }
}