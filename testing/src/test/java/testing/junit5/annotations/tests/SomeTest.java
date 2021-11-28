package testing.junit5.annotations.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeTest {
  @Test
  void name() {
    Assertions.assertThat(1+1 ==2).isTrue();
  }
}
