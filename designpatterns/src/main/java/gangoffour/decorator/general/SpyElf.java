package gangoffour.decorator.general;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpyElf implements Elf{
  private static final Logger LOGGER = LoggerFactory.getLogger(SpyElf.class);

  @Override
  public void attack() {
    LOGGER.info("The elf stabs!");
  }

  @Override
  public int getAttackPower() {
    return 15;
  }

  @Override
  public void fleeBattle() {
    LOGGER.info("The elf hides in the grass!");
  }
}
