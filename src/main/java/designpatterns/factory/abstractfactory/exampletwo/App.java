package designpatterns.factory.abstractfactory.exampletwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static designpatterns.factory.abstractfactory.exampletwo.App.FactoryMaker.KingdomType.ELF;
import static designpatterns.factory.abstractfactory.exampletwo.App.FactoryMaker.KingdomType.ORC;

public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  private King king;
  private Castle castle;
  private Army army;

  public static void main(String[] args) {

    var app = new App();

    LOGGER.info("Elf Kingdom");
    app.createKingdom(FactoryMaker.makeFactory(ELF));
    LOGGER.info(app.getArmy().getDescription());
    LOGGER.info(app.getCastle().getDescription());
    LOGGER.info(app.getKing().getDescription());

    LOGGER.info("Orc Kingdom");
    app.createKingdom(FactoryMaker.makeFactory(ORC));
    LOGGER.info(app.getArmy().getDescription());
    LOGGER.info(app.getCastle().getDescription());
    LOGGER.info(app.getKing().getDescription());
  }

  public void createKingdom(final KingdomFactory factory) {
    setKing(factory.createKing());
    setCastle(factory.createCastle());
    setArmy(factory.createArmy());
  }

  King getKing(final KingdomFactory factory) {
    return factory.createKing();
  }

  public King getKing() {
    return king;
  }

  private void setKing(final King king) {
    this.king = king;
  }

  Castle getCastle(final KingdomFactory factory) {
    return factory.createCastle();
  }

  public Castle getCastle() {
    return castle;
  }

  private void setCastle(final Castle castle) {
    this.castle = castle;
  }

  Army getArmy(final KingdomFactory factory) {
    return factory.createArmy();
  }

  public Army getArmy() {
    return army;
  }

  private void setArmy(final Army army) {
    this.army = army;
  }

  public static class FactoryMaker {

    public enum KingdomType {
      ELF, ORC
    }

    public static KingdomFactory makeFactory(KingdomType type) {
      switch (type) {
        case ELF:
          return new ElfKingdomFactory();
        case ORC:
          return new OrcKingdomFactory();
        default:
          throw new IllegalArgumentException("KingdomType not supported.");
      }
    }
  }
}