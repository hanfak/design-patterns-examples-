package testing.junit5.annotations.tags.packageA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClassATests {
  @Tag("production")
  @Test
  @DisplayName("testCaseA inside ClassATests inside packageA")
  public void testCaseA() {

  }
}
