package testing.junit5.annotations.tags.packageC;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClassCTest
{
  @Tag("development")
  @Tag("stage")
  @Test
  @DisplayName("testCaseC inside ClassCTest inside packageC")
  public void testCaseC() {

  }
}
