package testing.hamcrest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static testing.hamcrest.matchers.IsDivisibleBy.divisibleBy;
import static testing.hamcrest.matchers.IsOnlyDigits.onlyDigits;
import static testing.hamcrest.matchers.IsUppercase.uppercase;

public class HamcrestCustomUnitTests {
  
  @Test
  public final void givenAString_whenIsOnlyDigits_thenCorrect() {
    String digits = "123";

    assertThat(digits, is(onlyDigits()));
  }

  @Test
  public final void givenAString_whenIsNotOnlyDigits_thenCorrect() {
    String aphanumeric = "123ABC";

    assertThat(aphanumeric, is(not(onlyDigits())));
  }

  @Test
  public final void givenAnEvenInteger_whenDivisibleByTwo_thenCorrect() {
    Integer ten = 10;
    Integer two = 2;

    assertThat(ten, is(divisibleBy(two)));
  }

  @Test
  public final void givenAnOddInteger_whenNotDivisibleByTwo_thenCorrect() {
    Integer eleven = 11;
    Integer two = 2;

    assertThat(eleven, is(not(divisibleBy(two))));
  }

  @Test
  public final void givenAString_whenIsUppercase_thenCorrect() {
    String uppercaseWord = "HELLO";

    assertThat(uppercaseWord, is(uppercase()));
  }
}
