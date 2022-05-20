package fsm;

import fsm.creature.Creature;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.selector.MassSmallerThanOrEqSelector;
import fsm.selector.MovementSelector;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompositeSelectorTest {
  /**
   * Verify if the conjunction selector gives the correct results.
   */
  @Test
  public void testAndComposition() {
    final var swimmingHeavyCreature = mock(Creature.class);
    when(swimmingHeavyCreature.getMovement()).thenReturn(Movement.SWIMMING);
    when(swimmingHeavyCreature.getMass()).thenReturn(new Mass(100.0));

    final var swimmingLightCreature = mock(Creature.class);
    when(swimmingLightCreature.getMovement()).thenReturn(Movement.SWIMMING);
    when(swimmingLightCreature.getMass()).thenReturn(new Mass(25.0));

    final var lightAndSwimmingSelector = new MassSmallerThanOrEqSelector(50.0)
            .and(new MovementSelector(Movement.SWIMMING));
    assertFalse(lightAndSwimmingSelector.test(swimmingHeavyCreature));
    assertTrue(lightAndSwimmingSelector.test(swimmingLightCreature));
  }

  /**
   * Verify if the disjunction selector gives the correct results.
   */
  @Test
  public void testOrComposition() {
    final var swimmingHeavyCreature = mock(Creature.class);
    when(swimmingHeavyCreature.getMovement()).thenReturn(Movement.SWIMMING);
    when(swimmingHeavyCreature.getMass()).thenReturn(new Mass(100.0));

    final var swimmingLightCreature = mock(Creature.class);
    when(swimmingLightCreature.getMovement()).thenReturn(Movement.SWIMMING);
    when(swimmingLightCreature.getMass()).thenReturn(new Mass(25.0));

    final var lightOrSwimmingSelector = new MassSmallerThanOrEqSelector(50.0)
            .or(new MovementSelector(Movement.SWIMMING));
    assertTrue(lightOrSwimmingSelector.test(swimmingHeavyCreature));
    assertTrue(lightOrSwimmingSelector.test(swimmingLightCreature));
  }

  /**
   * Verify if the negation selector gives the correct results.
   */
  @Test
  public void testNotComposition() {
    final var swimmingHeavyCreature = mock(Creature.class);
    when(swimmingHeavyCreature.getMovement()).thenReturn(Movement.SWIMMING);
    when(swimmingHeavyCreature.getMass()).thenReturn(new Mass(100.0));

    final var swimmingLightCreature = mock(Creature.class);
    when(swimmingLightCreature.getMovement()).thenReturn(Movement.SWIMMING);
    when(swimmingLightCreature.getMass()).thenReturn(new Mass(25.0));

    final var heavySelector = new MassSmallerThanOrEqSelector(50.0).not();
    assertTrue(heavySelector.test(swimmingHeavyCreature));
    assertFalse(heavySelector.test(swimmingLightCreature));
  }
}