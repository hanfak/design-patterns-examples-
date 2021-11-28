package javalibraries.equalshashcode;

import javalibraries.equalshashcode.effectivejava.PhoneNumber1;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// How to test equals
public class PhoneNumber1Test {
  @Test
  public void testReflexive() {
    PhoneNumber1 p1 = PhoneNumber1.of(123, 1234);
    assertTrue(p1.equals(p1));
  }

  @Test
  public void testSymmetrical() {
    PhoneNumber1 x = PhoneNumber1.of(123, 1234);
    PhoneNumber1 y = PhoneNumber1.of(123, 1234);
    assertTrue(x.equals(y));
    assertTrue(y.equals(x));
  }

  @Test
  public void testTransitive() {
    PhoneNumber1 x = PhoneNumber1.of(123, 1234);
    PhoneNumber1 y = PhoneNumber1.of(123, 1234);
    PhoneNumber1 z = PhoneNumber1.of(123, 1234);
    assertTrue(x.equals(y));
    assertTrue(y.equals(z));
    assertTrue(x.equals(z));
  }

  @Test
  public void testConsistent() {
    PhoneNumber1 x = PhoneNumber1.of(123, 1234);
    PhoneNumber1 y = PhoneNumber1.of(123, 1234);
    assertTrue(x.equals(y));
    assertTrue(x.equals(y));
    assertTrue(x.equals(y));
    assertTrue(x.equals(y));
  }

  @Test
  public void testNonNullity() {
    PhoneNumber1 x = PhoneNumber1.of(123, 1234);
    assertFalse(x.equals(null));
  }
}