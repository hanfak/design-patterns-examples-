package gangoffour.decorator.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
  private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

  public static void main(String[] args) {
    LOGGER.info("A simple looking elf approaches.");
    Elf simpleElf = new SimpleElf();
    simpleElf.attack();
    LOGGER.info("Simple elf power {}.\n", simpleElf.getAttackPower());

    LOGGER.info("Legalos appears.");
    Elf legalos = new SoldierElf(new SimpleElf());
    legalos.attack();
    LOGGER.info("Simple elf power {}.\n", legalos.getAttackPower());
  }
}
