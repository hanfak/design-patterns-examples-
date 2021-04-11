package testing.junit5.annotations.tags.packageB;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClassBTest
{
  @Tag("development")
  @Test
  @DisplayName("testCaseB inside ClassBTest inside packageB")
  public void testCaseB() {

  }

  @Tag("stage")
  @Test
  @DisplayName("testCaseB1 inside ClassBTest inside packageB")
  public void testCaseB1() {

  }
}
