package testing.junit5.annotations.displayname;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@DisplayNameGeneration(Example03.ReplaceCamelCase.class)
public class Example03 {
  @Test
  void camelCaseName() {
  }

  @Nested
  @DisplayNameGeneration(Example03.IndicativeSentences.class)
  class ANumberIsFizz {
    @Test
    void ifItIsDivisibleByThree() {
    }

    @Test
    void ifItIsOneOfTheFollowingNumbers() {
    }
  }

  @Nested
  @DisplayNameGeneration(Example03.IndicativeSentences.class)
  class ANumberIsBuzz {
    @Test
    void ifItIsDivisibleByFive() {
    }

    @Test
    void ifItIsOneOfTheFollowingNumbers() {
    }
  }

  static class IndicativeSentences extends ReplaceCamelCase {
    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
      return super.generateDisplayNameForNestedClass(nestedClass) + "...";
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
      return replaceCamelCase(testClass.getSimpleName() + " " + testMethod.getName()) + ".";
    }
  }

  static class ReplaceCamelCase extends DisplayNameGenerator.Standard {
    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
      return replaceCamelCase(super.generateDisplayNameForClass(testClass));
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
      return replaceCamelCase(super.generateDisplayNameForNestedClass(nestedClass));
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
      return this.replaceCamelCase(testMethod.getName()) + DisplayNameGenerator.parameterTypesAsString(testMethod);
    }

    String replaceCamelCase(String camelCase) {
      StringBuilder result = new StringBuilder();
      result.append(camelCase.charAt(0));
      for (int i=1; i<camelCase.length(); i++) {
        if (Character.isUpperCase(camelCase.charAt(i))) {
          result.append(' ');
          result.append(Character.toLowerCase(camelCase.charAt(i)));
        } else {
          result.append(camelCase.charAt(i));
        }
      }
      return result.toString();
    }
  }
}
