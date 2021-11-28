package testing.junit5.annotations;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Example01 {
  static Logger log = LoggerFactory.getLogger(Example01.class);

  @BeforeAll
  static void setup() {
    log.info("@BeforeAll - executes once before all test methods in this class");
  }

  @BeforeEach
  void init() {
    log.info("@BeforeEach - executes before each test method in this class");
  }

  @Test
  void firstTest() {
    log.info("FIRST");
    assertTrue(Stream.of(1, 2, 3)
        .mapToInt(i -> i)
        .sum() > 5, () -> "Sum should be greater than 5");
  }

  @Test
  void secondTest() {
    log.info("SECOND");
    assertFalse(Stream.of(1, 2, 3)
        .mapToInt(i -> i)
        .sum() < 5, () -> "Sum should be greater than 5");
  }

  @AfterEach
  void tearDown() {
    log.info("@AfterEach - executed after each test method.");
  }

  @AfterAll
  static void done() {
    log.info("@AfterAll - executed after all test methods.");
  }
}
