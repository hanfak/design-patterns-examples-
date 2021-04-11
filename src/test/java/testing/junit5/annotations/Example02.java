package testing.junit5.annotations;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@Disabled // disbles all test in class
@DisplayName("Test suite name")
class Example02 {
  static Logger log = LoggerFactory.getLogger(Example02.class);

  @Test
  @Disabled
  void firstTest() {
    log.info("FIRST");
    assertTrue(Stream.of(1, 2, 3)
        .mapToInt(i -> i)
        .sum() > 5, () -> "Sum should be greater than 5");
  }

  @Test
  @DisplayName("This is the name of the test")
  void secondTest() {
    log.info("SECOND");
    assertFalse(Stream.of(1, 2, 3)
        .mapToInt(i -> i)
        .sum() < 5, () -> "Sum should be greater than 5");
  }
}
