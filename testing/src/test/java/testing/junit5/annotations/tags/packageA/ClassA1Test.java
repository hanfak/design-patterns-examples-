package testing.junit5.annotations.tags.packageA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClassA1Test {
  @Tag("stage")
  @Test
  @DisplayName("testCaseA1 inside ClassA1Test inside packageA")
  public void testCaseA1() {

  }
}
