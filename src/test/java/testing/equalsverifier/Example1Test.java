package testing.equalsverifier;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.EqualsVerifierReport;
import org.junit.Test;
// https://jqno.nl/equalsverifier/
public class Example1Test {

  @Test
  public void simpleExample() {
    EqualsVerifier.forClass(SomeObject.class).verify();
    EqualsVerifierReport report = EqualsVerifier.forClass(SomeObject.class).report();
    System.out.println("report.getMessage() = " + report.getMessage());
    System.out.println(report.isSuccessful());
  }

  @Test
  public void unusedFieldInEqualsAndHashcodeFailedExample() {
    EqualsVerifierReport report = EqualsVerifier.forClass(SomeObject1.class).report();
    System.out.println("report.getMessage() = " + report.getMessage());
    System.out.println(report.isSuccessful());
    EqualsVerifier.forClass(SomeObject1.class).verify();
  }

  @Test
  public void unusedFieldInEqualsAndHashcodePassExample() {
    EqualsVerifierReport report = EqualsVerifier.forClass(SomeObject1.class).withIgnoredFields("z").report();
    System.out.println("report.getMessage() = " + report.getMessage());
    System.out.println(report.isSuccessful());
    EqualsVerifier.forClass(SomeObject1.class).withIgnoredFields("z").verify();
  }

  @Test
  public void unusedFieldInEqualsAndNoHashcodeFailedExample() {
    EqualsVerifierReport report = EqualsVerifier.forClass(SomeObject2.class).withIgnoredFields("z").report();
    System.out.println("report.getMessage() = " + report.getMessage());
    System.out.println(report.isSuccessful());
    EqualsVerifier.forClass(SomeObject2.class).withIgnoredFields("z").verify();
  }
}