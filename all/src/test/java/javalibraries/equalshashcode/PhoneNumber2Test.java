package javalibraries.equalshashcode;

import javalibraries.equalshashcode.effectivejava.PhoneNumber2;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// How to test equals
public class PhoneNumber2Test {
  @Test
  public void testReflexive() {
    PhoneNumber2 p1 = PhoneNumber2.of(123, 1234);
    assertTrue(p1.equals(p1));
  }

  @Test
  public void testSymmetrical() {
    PhoneNumber2 x = PhoneNumber2.of(123, 1234);
    PhoneNumber2 y = PhoneNumber2.of(123, 1234);
    assertTrue(x.equals(y));
    assertTrue(y.equals(x));
  }

  @Test
  public void testTransitive() {
    PhoneNumber2 x = PhoneNumber2.of(123, 1234);
    PhoneNumber2 y = PhoneNumber2.of(123, 1234);
    PhoneNumber2 z = PhoneNumber2.of(123, 1234);
    assertTrue(x.equals(y));
    assertTrue(y.equals(z));
    assertTrue(x.equals(z));
  }

  @Test
  public void testConsistent() {
    PhoneNumber2 x = PhoneNumber2.of(123, 1234);
    PhoneNumber2 y = PhoneNumber2.of(123, 1234);
    assertTrue(x.equals(y));
    assertTrue(x.equals(y));
    assertTrue(x.equals(y));
    assertTrue(x.equals(y));
  }

  @Test
  public void testNonNullity() {
    PhoneNumber2 x = PhoneNumber2.of(123, 1234);
    assertFalse(x.equals(null));
  }
}