package testing.assertj.custom;

public class Assertions {
  public static PersonAssert assertThat(Person actual) {
    return new PersonAssert(actual);
  }

  // static designpatterns.factory methods of other assertion classes
}
