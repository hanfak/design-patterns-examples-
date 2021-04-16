package testing.assertj.exceptions;


import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

public class Java8StyleAssertions {

  @Test
  public void whenGettingOutOfBoundsItem_thenIndexOutOfBoundsException() {
    assertThatThrownBy(() -> {
      ArrayList<String> myStringList = new ArrayList<>(Arrays.asList("String one", "String two"));
      myStringList.get(2);
    }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageStartingWith("Index 2")
        .hasMessageContaining("2")
        .hasMessageEndingWith("for length 2")
        .hasMessage("Index %s out of bounds for length %s", 2, 2)
        .hasMessageMatching("Index \\d+ out of bounds for length \\d+")
        .hasNoCause();
  }

  @Test
  public void whenException() {
    Supplier<IllegalStateException> x = IllegalStateException::new;
    throwExceotion(x);
    Predicate<String> a = Objects::isNull;
    Predicate<String> a1 = a.or(y -> y.contains("a"));
    Pair<Predicate<String>, Supplier<IllegalStateException>> p = Pair.of(a1, x);
    Pair<Predicate<String>, String> p1 = Pair.of(a1, "reason");

    // rules -> filter (all and/or/complex) then map action else do nothing
    // rules -> filter (all and/or/complex) then map action else throw
    // rules -> filter (single)  then map action else do nothing
    // rules -> filter (single) then map action else throw

    // combined validation using function composition

    //https://www.baeldung.com/java-predicate-chain

    // on type
    // On list
    // On Optional
    // On primitive

    System.out.println(validate(p, "Hello"));
    System.out.println(validate1(p1, "Hallo"));
    System.out.println(validate(p, "Hallo"));


    assertThatThrownBy(() -> {
      throw new IOException();
    })
        .isInstanceOf(IOException.class)
        .hasStackTraceContaining("IOException");
  }

  private String validate(Pair<Predicate<String>, Supplier<IllegalStateException>> p, String arg) {
    return Optional.of(arg)
        .filter(not(p.getLeft()))
        .orElseThrow(p.getRight());
  }

  private String validate1(Pair<Predicate<String>, String> p, String arg) {
    return Optional.of(arg)
        .filter(not(p.getLeft()))
        .orElse(p.getRight());
  }

  private void throwExceotion(Supplier<IllegalStateException> x) {
    try {
      throw x.get();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void whenWrappingException_thenCauseInstanceOfWrappedExceptionType() {
    assertThatThrownBy(() -> {
      try {
        throw new IOException();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }).isInstanceOf(RuntimeException.class)
        .hasCauseInstanceOf(IOException.class)
        .hasStackTraceContaining("IOException");
  }

  @Test
  public void whenDividingByZero_thenArithmeticException() {
    assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
      int numerator = 10;
      int denominator = 0;
      int quotient = numerator / denominator;
    }).withMessageContaining("/ by zero");

    // Alternatively:

    Throwable thrown = catchThrowable(() -> {
      int numerator = 10;
      int denominator = 0;
      int quotient = numerator / denominator;
    });

    assertThat(thrown).isInstanceOf(ArithmeticException.class)
        .hasMessageContaining("/ by zero");
  }
}
