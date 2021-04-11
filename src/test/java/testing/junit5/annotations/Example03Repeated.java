package testing.junit5.annotations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example03Repeated {
  // value = number of repetitions
  @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}") //These are fields access via the test params classes
  @DisplayName("RepeatingTest")
  void customDisplayName(RepetitionInfo repInfo, TestInfo testInfo) {
    int i = 3;
    System.out.println(testInfo.getDisplayName() +
        "-->" + repInfo.getCurrentRepetition()
    );

    assertEquals(repInfo.getCurrentRepetition(), i);
  }
}
