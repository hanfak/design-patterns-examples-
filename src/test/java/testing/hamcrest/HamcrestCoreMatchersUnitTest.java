package testing.hamcrest;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class HamcrestCoreMatchersUnitTest {

  @Test
  public void givenTestInput_WhenUsingIsForMatch() {
    String testString = "hamcrest core";

    assertThat(testString, is("hamcrest core"));
    assertThat(testString, is(equalTo("hamcrest core")));
  }

  @Test
  public void givenDifferentStaticTypeTestInput_WhenUsingEqualToObject_ThenCorrect() {
    Object original = 100;

    assertThat(original, equalToObject(100));
  }

  @Test
  public void givenTestInput_WhenUsingInstanceOfForClassTypeCheck() {
    assertThat("hamcrest", is(instanceOf(String.class)));
  }

  @Test
  public void givenTestInput_WhenUsingIsA_ThenAssertType() {
    assertThat("hamcrest core", isA(String.class));
  }

  @Test
  public void givenTestInput_WhenUsingEqualToMatcherForEquality() {
    String actualString = "Hamcrest Core";
    List<String> actualList = Lists.newArrayList("hamcrest", "core");

    assertThat(actualString, is(equalTo("Hamcrest Core")));
    assertThat(actualList, is(equalTo(Lists.newArrayList("hamcrest", "core"))));
  }

  @Test
  public void givenTestInput_WhenUsingNotForMatch() {
    String testString = "hamcrest";
    
    assertThat(testString, not("hamcrest core"));
    assertThat(testString, is(not(equalTo("hamcrest core"))));
    assertThat(testString, is(not(instanceOf(Integer.class))));
  }

  @Test
  public void givenTestInput_WhenUsingNullValueForNullCheck() {
    Integer nullObject = null;

    assertThat(nullObject, is(nullValue()));
    assertThat(nullObject, is(nullValue(Integer.class)));
  }

  @Test
  public void givenTestInput_WhenUsingNotNullValueForNotNullCheck() {
    Integer testNumber = 123;
    
    assertThat(testNumber, is(notNullValue()));
    assertThat(testNumber, is(notNullValue(Integer.class)));
  }

  @Test
  public void givenString_WhenStartsWith_ThenCorrect() {
    String testString = "hamcrest core";
    
    assertThat(testString, startsWith("hamcrest"));
  }

  @Test
  public void giveString_WhenStartsWithIgnoringCase_ThenCorrect() {
    String testString = "hamcrest core";

    assertThat(testString, startsWithIgnoringCase("HAMCREST"));
  }

  @Test
  public void givenString_WhenEndsWith_ThenCorrect() {
    String testString = "hamcrest core";

    assertThat(testString, endsWith("core"));
  }

  @Test
  public void givenString_WhenEndsWithIgnoringCase_ThenCorrect() {
    String testString = "hamcrest core";

    assertThat(testString, endsWithIgnoringCase("CORE"));
  }

  @Test
  public void givenString_WhenContainsString_ThenCorrect() {
    String testString = "hamcrest core";

    assertThat(testString, containsString("co"));
  }

  @Test
  public void givenString_WhenContainsStringIgnoringCase_ThenCorrect() {
    String testString = "hamcrest core";

    assertThat(testString, containsStringIgnoringCase("CO"));
  }

  @Test
  public void givenTestInput_WhenUsingHasItemInCollection() {
    List<String> list = Lists.newArrayList("java", "spring", "baeldung");

    assertThat(list, hasItem("java"));
    assertThat(list, hasItem(isA(String.class)));
  }

  @Test
  public void givenTestInput_WhenUsingHasItemsInCollection() {
    List<String> list = Lists.newArrayList("java", "spring", "baeldung");

    assertThat(list, hasItems("java", "baeldung"));
    assertThat(list, hasItems(isA(String.class), endsWith("ing")));
  }

  @Test
  public void givenTestInput_WhenUsingAnyForClassType() {

    assertThat("hamcrest", is(any(String.class)));
    assertThat("hamcrest", is(any(Object.class)));
  }

  @Test
  public void givenTestInput_WhenUsingAllOfForAllMatchers() {
    String testString = "Hamcrest Core";
    
    assertThat(testString, allOf(startsWith("Ham"), endsWith("ore"), containsString("Core")));
  }

  @Test
  public void givenTestInput_WhenUsingAnyOfForAnyMatcher() {
    String testString = "Hamcrest Core";

    assertThat(testString, anyOf(startsWith("Ham"), containsString("baeldung")));
  }

  @Test
  public void givenTestInput_WhenUsingBothForMatcher() {
    String testString = "Hamcrest Core Matchers";

    assertThat(testString, both(startsWith("Ham")).and(containsString("Core")));
  }

  @Test
  public void givenTestInput_WhenUsingEitherForMatcher() {
    String testString = "Hamcrest Core Matchers";

    assertThat(testString, either(startsWith("Bael")).or(containsString("Core")));
  }

  @Test
  public void givenTestInput_WhenUsingEveryItemForMatchInCollection() {
    List<String> testItems = Lists.newArrayList("Common", "Core", "Combinable");

    assertThat(testItems, everyItem(startsWith("Co")));
  }

  @Test
  public void givenTwoTestInputs_WhenUsingSameInstanceForMatch() {
    String string1 = "hamcrest";
    String string2 = string1;

    assertThat(string1, is(sameInstance(string2)));
  }

  @Test
  public void givenTwoTestInputs_WhenUsingTheInstanceForMatch() {
    String string1 = "hamcrest";
    String string2 = string1;

    assertThat(string1, is(theInstance(string2)));
  }
}
