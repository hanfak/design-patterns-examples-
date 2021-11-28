package testing.assertj;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.time.LocalDate.ofYearDay;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJJava8UnitTest {

  @Test
  public void givenOptional_shouldAssert() {
    final Optional<String> givenOptional = Optional.of("something");

    assertThat(givenOptional).isPresent().hasValue("something");
  }

  @Test
  public void givenPredicate_shouldAssert() {
    final Predicate<String> predicate = s -> s.length() > 4;

    assertThat(predicate)
            .accepts("aaaaa", "bbbbb")
            .rejects("a", "b")
            .acceptsAll(asList("aaaaa", "bbbbb"))
            .rejectsAll(asList("a", "b"));
  }

  @Test
  public void givenLocalDate_shouldAssert() {
    final LocalDate givenLocalDate = LocalDate.of(2016, 7, 8);
    final LocalDate todayDate = LocalDate.now();

    assertThat(givenLocalDate)
            .isBefore(LocalDate.of(2020, 7, 8))
            .isAfterOrEqualTo(LocalDate.of(1989, 7, 8));

    assertThat(todayDate)
            .isAfter(LocalDate.of(1989, 7, 8))
            .isToday();
  }

  @Test
  public void givenLocalDateTime_shouldAssert() {
    final LocalDateTime givenLocalDate = LocalDateTime.of(2016, 7, 8, 12, 0);

    assertThat(givenLocalDate).isBefore(LocalDateTime.of(2020, 7, 8, 11, 2));
  }

  @Test
  public void givenLocalTime_shouldAssert() {
    final LocalTime givenLocalTime = LocalTime.of(12, 15);

    assertThat(givenLocalTime)
            .isAfter(LocalTime.of(1, 0))
            .hasSameHourAs(LocalTime.of(12, 0));
  }

  @Test
  public void givenList_shouldAssertFlatExtracting() {
    final List<LocalDate> givenList = asList(ofYearDay(2016, 5), ofYearDay(2015, 6));

    assertThat(givenList)
            .flatExtracting(LocalDate::getYear)
            .contains(2015);
  }

  @Test
  public void givenList_shouldAssertFlatExtractingLeapYear() {
    final List<LocalDate> givenList = asList(ofYearDay(2016, 5), ofYearDay(2015, 6));

    assertThat(givenList)
            .flatExtracting(LocalDate::isLeapYear)
            .contains(true);
  }

  @Test
  public void givenList_shouldAssertFlatExtractingClass() {
    final List<LocalDate> givenList = asList(ofYearDay(2016, 5), ofYearDay(2015, 6));

    assertThat(givenList)
            .flatExtracting(Object::getClass)
            .contains(LocalDate.class);
  }

  @Test
  public void givenList_shouldAssertMultipleFlatExtracting() {
    final List<LocalDate> givenList = asList(ofYearDay(2016, 5), ofYearDay(2015, 6));

    assertThat(givenList)
            .flatExtracting(LocalDate::getYear, LocalDate::getDayOfMonth)
            .contains(2015, 6);
  }

  @Test
  public void givenString_shouldSatisfy() {
    final String givenString = "someString";

    assertThat(givenString).satisfies(s -> {
      assertThat(s).isNotEmpty();
      assertThat(s).hasSize(10);
    });
  }

  @Test
  public void givenString_shouldMatch() {
    final String emptyString = "";

    assertThat(emptyString).matches(String::isEmpty);
  }

  @Test
  public void givenList_shouldHasOnlyOneElementSatisfying() {
    final List<String> givenList = singletonList("");

    assertThat(givenList).hasOnlyOneElementSatisfying(s -> assertThat(s).isEmpty());
  }
}

