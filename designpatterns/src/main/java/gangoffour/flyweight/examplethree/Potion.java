package gangoffour.flyweight.examplethree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Potion {
  void drink();
}

class HealingPotion implements Potion {
  private static final Logger LOGGER = LoggerFactory.getLogger(HealingPotion.class);
  @Override
  public void drink() {
    LOGGER.info("You feel healed. (Potion={})", System.identityHashCode(this));
  }
}

class HolyWaterPotion implements Potion {
  private static final Logger LOGGER = LoggerFactory.getLogger(HolyWaterPotion.class);
  @Override
  public void drink() {
    LOGGER.info("You feel blessed. (Potion={})", System.identityHashCode(this));
  }
}

class InvisibilityPotion implements Potion {
  private static final Logger LOGGER = LoggerFactory.getLogger(InvisibilityPotion.class);
  @Override
  public void drink() {
    LOGGER.info("You become invisible. (Potion={})", System.identityHashCode(this));
  }
}

class PoisonPotion implements Potion {

  private static final Logger LOGGER = LoggerFactory.getLogger(PoisonPotion.class);

  @Override
  public void drink() {
    LOGGER.info("Urgh! This is poisonous. (Potion={})", System.identityHashCode(this));
  }
}

class StrengthPotion implements Potion {

  private static final Logger LOGGER = LoggerFactory.getLogger(StrengthPotion.class);

  @Override
  public void drink() {
    LOGGER.info("You feel strong. (Potion={})", System.identityHashCode(this));
  }
}