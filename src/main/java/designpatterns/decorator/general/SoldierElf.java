package designpatterns.decorator.general;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoldierElf implements Elf{
  private static final Logger LOGGER = LoggerFactory.getLogger(SoldierElf.class);
  private Elf elf;

  public SoldierElf(Elf elf) {
    this.elf = elf;
  }

  @Override
  public void attack() {
    LOGGER.info("The elf shoots an super arrow!");
  }

  @Override
  public int getAttackPower() {
    return 20;
  }

  @Override
  public void fleeBattle() {
    LOGGER.info("The elf climbs tree!");
  }
}
