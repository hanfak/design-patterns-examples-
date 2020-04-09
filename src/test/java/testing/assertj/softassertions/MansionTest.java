package testing.assertj.softassertions;

import org.assertj.core.api.BDDSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static testing.assertj.softassertions.Race.*;
import static testing.assertj.softassertions.Ring.oneRing;

public class MansionTest {
  @Test
  public void host_dinner_party_where_nobody_dies() {
    mansion.hostPotentiallyMurderousDinnerParty();
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(mansion.guests()).as("Living Guests").isEqualTo(7);
    softly.assertThat(mansion.kitchen()).as("Kitchen").isEqualTo("clean");
    softly.assertThat(mansion.library()).as("Library").isEqualTo("clean");
    softly.assertThat(mansion.revolverAmmo()).as("Revolver Ammo").isEqualTo(6);
    softly.assertThat(mansion.candlestick()).as("Candlestick").isEqualTo("pristine");
    softly.assertThat(mansion.colonel()).as("Colonel").isEqualTo("well kempt");
    softly.assertThat(mansion.professor()).as("Professor").isEqualTo("well kempt");
    // Try block will catch exceptions, and not fail test
    try {
      softly.assertAll();
    } catch (AssertionError e) {
      logAssertionErrorMessage("SoftAssertion errors example", e);
    }
  }

  @Test
  public void lotr_soft_assertions_example() {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(frodo.getRace().getName()).as("check Frodo's race").isEqualTo("Orc");
    softly.assertThat(aragorn.age).as("check Aragorn's age").isGreaterThan(500);
    softly.assertThat(gandalf).as("gandalf vs sauron").isEqualTo(sauron);
    softly.assertAll(); // will fail test if one test fails
  }

  @Test
  public void lotr_soft_assertions_example_with_assertSoftly() {
    try {
      SoftAssertions.assertSoftly(softly -> {
        softly.assertThat(frodo.getRace().getName()).as("check Frodo's race").isEqualTo("Orc");
        softly.assertThat(aragorn.age).as("check Aragorn's age").isGreaterThan(500);
        softly.assertThat(gandalf).as("gandalf vs sauron").isEqualTo(sauron);
      });
    } catch (AssertionError e) {
      // expected
    }
  }

  @Test
  public void chained_soft_assertions_example() {
    String name = "Michael Jordan - Bulls";
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(name)
            .startsWith("Mike")
            .contains("Lakers")
            .endsWith("Chicago");

    try {
      softly.assertAll();
    } catch (AssertionError e) {
      logAssertionErrorMessage("SoftAssertion errors example", e);
    }
  }

  @Test
  public void host_dinner_party_where_nobody_dies_bdd_style() {
    Mansion mansion = new Mansion();
    mansion.hostPotentiallyMurderousDinnerParty();
    BDDSoftAssertions softly = new BDDSoftAssertions();
    softly.then(mansion.guests()).as("Living Guests").isEqualTo(7);
    softly.then(mansion.kitchen()).as("Kitchen").isEqualTo("clean");
    softly.then(mansion.library()).as("Library").isEqualTo("clean");
    softly.then(mansion.revolverAmmo()).as("Revolver Ammo").isEqualTo(6);
    softly.then(mansion.candlestick()).as("Candlestick").isEqualTo("pristine");
    softly.then(mansion.colonel()).as("Colonel").isEqualTo("well kempt");
    softly.then(mansion.professor()).as("Professor").isEqualTo("well kempt");
    try {
      softly.assertAll();
    } catch (AssertionError e) {
      logAssertionErrorMessage("BDD SoftAssertion errors example", e);
    }
  }

  @Test
  public void chained_bdd_soft_assertions_example() {
    String name = "Michael Jordan - Bulls";
    BDDSoftAssertions softly = new BDDSoftAssertions();
    softly.then(name).startsWith("Mike").contains("Lakers").endsWith("Chicago");
    try {
      softly.assertAll();
    } catch (AssertionError e) {
      logAssertionErrorMessage("BDD SoftAssertion errors example", e);
    }
  }

  @Test
  public void soft_assertions_combined_with_extracting_example() {
    BDDSoftAssertions softly = new BDDSoftAssertions();
    softly.then(fellowshipOfTheRing).extracting("name", "age").contains(tuple("Sauron", 1000));
    softly.then(fellowshipOfTheRing).extracting("race.name").contains("Man", "Orc");
    try {
      softly.assertAll();
    } catch (AssertionError e) {
      logAssertionErrorMessage("BDD SoftAssertion errors example", e);
    }
  }

  @Test
  public void soft_assertions_combined_with_filtering_example() {
    BDDSoftAssertions softly = new BDDSoftAssertions();
    softly.then(fellowshipOfTheRing).filteredOn("name", "Frodo").containsOnly(frodo);
    softly.then(fellowshipOfTheRing).filteredOn("name", "Frodo").isEmpty();
    try {
      softly.assertAll();
    } catch (AssertionError e) {
      logAssertionErrorMessage("BDD SoftAssertion errors example", e);
      return;
    }
    throw new AssertionError("should have caught soft assertion errors properly");
  }

  @Test
  public void soft_assertions_example_with_arrays() {
    String[] players = Arrays.array("Michael Jordan", "Tim Duncan");
    BDDSoftAssertions softly = new BDDSoftAssertions();
    softly.then(players).contains("Kobe Bryant").doesNotContain("Tim Duncan");
    try {
      softly.assertAll();
    } catch (AssertionError e) {
      logAssertionErrorMessage("BDD SoftAssertion errors example", e);
    }
  }

  @Test
  public void should_work_with_comparable() throws Exception {

    SoftAssertions softly = new SoftAssertions();
    Example example = new Example(0);
    softly.assertThat((Object) example).isEqualTo(example);
    softly.assertAll();
  }

  @Test
  public void should_return_correct_errors_count() {
    SoftAssertions soft = new SoftAssertions();

    soft.assertThat("foo").startsWith("boo");
    assertThat(soft.errorsCollected()).hasSize(1);

    soft.assertThat("bar").startsWith("far");
    assertThat(soft.errorsCollected()).hasSize(2);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void should_work_with_methods_switching_the_object_under_test() {
    // GIVEN
    SoftAssertions softly = new SoftAssertions();
    Object sneakyString = "I'm actually a String";
    Object sneakyList = fellowshipOfTheRing;
    // WHEN
    softly.assertThat(fellowshipOfTheRing)
            .flatExtracting(TolkienCharacter::getName, tc -> tc.getRace().getName())
            .contains("Hobbit", "Frodo", "Elf", "Legolas")
            .contains("Sauron"); // fail
    softly.assertThat(fellowshipOfTheRing)
            .size()
            .isLessThan(100)
            .isGreaterThan(100) // fail
            .returnToIterable()
            .filteredOn("race", HOBBIT)
            .containsOnly(sam, frodo, pippin, merry)
            .contains(gandalf) // fail
            .extracting(TolkienCharacter::getName)
            .contains("Frodo")
            .contains("Elrond"); // fail
    softly.assertThat(ringBearers)
            .size()
            .isLessThan(10)
            .isGreaterThan(10) // fail
            .returnToMap()
            .containsKey(oneRing)
            .containsValue(aragorn); // fail
    softly.assertThat(Optional.of("Yoda"))
            .flatMap(s -> s == null ? Optional.empty() : Optional.of(s.toUpperCase()))
            .contains("YODA")
            .contains("yoda") // fail
            .map(String::length)
            .hasValue(4)
            .hasValue(777); // fail
    softly.assertThat(sneakyString)
            .asString()
            .endsWith("ing")
            .contains("oh no"); // fail
    softly.assertThat(sneakyList)
            .asList()
            .flatExtracting("name", "race.name")
            .contains("Hobbit", "Frodo", "Elf", "Legolas")
            .contains("Saruman"); // fail

    // THEN
    List<Throwable> errors = softly.errorsCollected();
    assertThat(errors).hasSize(10);
    assertThat(errors.get(0)).hasMessageContaining("Sauron");
    assertThat(errors.get(1)).hasMessageContaining("100");
    assertThat(errors.get(2)).hasMessageContaining("Gandalf");
    assertThat(errors.get(3)).hasMessageContaining("Elrond");
    assertThat(errors.get(4)).hasMessageContaining("10");
    assertThat(errors.get(5)).hasMessageContaining("Aragorn");
    assertThat(errors.get(6)).hasMessageContaining("yoda");
    assertThat(errors.get(7)).hasMessageContaining("777");
    assertThat(errors.get(8)).hasMessageContaining("oh no");
    assertThat(errors.get(9)).hasMessageContaining("Saruman");
  }

  private static final Logger logger = LoggerFactory.getLogger("[ERROR MESSAGE EXAMPLE]");
  private static final String ERROR_MESSAGE_EXAMPLE_FOR_ASSERTION = "{} assertion :\n{}\n";
  protected final TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
  protected final TolkienCharacter gandalf = new TolkienCharacter("Gandalf", 2020, MAIA);
  protected final TolkienCharacter aragorn = new TolkienCharacter("Aragorn", 87, MAN);
  protected final TolkienCharacter sauron = new TolkienCharacter("Sauron", 50000, MAIA);
  protected final TolkienCharacter sam = new TolkienCharacter("Sam", 38, HOBBIT);
  protected final TolkienCharacter merry = new TolkienCharacter("Merry", 36, HOBBIT);
  protected final TolkienCharacter pippin = new TolkienCharacter("Pippin", 28, HOBBIT);
  protected final TolkienCharacter gimli = new TolkienCharacter("Gimli", 139, DWARF);
  protected final TolkienCharacter legolas = new TolkienCharacter("Legolas", 1000, ELF);
  protected final TolkienCharacter boromir = new TolkienCharacter("Boromir", 37, MAN);
  protected final TolkienCharacter galadriel = new TolkienCharacter("Galadriel", 3000, ELF);
  protected final TolkienCharacter elrond = new TolkienCharacter("Elrond", 3000, ELF);
  protected final List<TolkienCharacter> fellowshipOfTheRing = new ArrayList<>();
  protected final Map<Ring, TolkienCharacter> ringBearers = new LinkedHashMap<>();


  @Before
  public void setUp() throws Exception {
    fellowshipOfTheRing.add(frodo);
    fellowshipOfTheRing.add(sam);
    fellowshipOfTheRing.add(merry);
    fellowshipOfTheRing.add(pippin);
    fellowshipOfTheRing.add(gandalf);
    fellowshipOfTheRing.add(legolas);
    fellowshipOfTheRing.add(gimli);
    fellowshipOfTheRing.add(aragorn);
    fellowshipOfTheRing.add(boromir);
    ringBearers.put(Ring.nenya, galadriel);
    ringBearers.put(Ring.narya, gandalf);
    ringBearers.put(Ring.vilya, elrond);
    ringBearers.put(oneRing, frodo);
  }

  private static void logAssertionErrorMessage(String assertionContext, AssertionError e) {
    logger.info(ERROR_MESSAGE_EXAMPLE_FOR_ASSERTION, assertionContext, e.getMessage());
  }

  private final Mansion mansion = new Mansion();

  class Example implements Comparable<Example> {

    int id;

    Example(int id) {
      this.id = id;
    }

    @Override
    public int compareTo(Example that) {
      return this.id - that.id;
    }
  }
}