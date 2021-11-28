package testing.junit5.annotations.displayname;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Example01 {
  @Nested
  class when_doing_something {

    @Test
    void then_something_shouldHappen() {
    }

    @Test
    @DisplayName("@DisplayName takes precedence over generation")
    void override_generator() {
    }
  }
}
