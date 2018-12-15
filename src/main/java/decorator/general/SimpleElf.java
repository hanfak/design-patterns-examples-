package decorator.general;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleElf implements Elf{
  private static final Logger LOGGER = LoggerFactory.getLogger(SimpleElf.class);

  @Override
  public void attack() {
    LOGGER.info("The elf shoots an arrow!");
  }

  @Override
  public int getAttackPower() {
    return 10;
  }

  @Override
  public void fleeBattle() {
    LOGGER.info("The elf runs away in horror!");
  }
}
