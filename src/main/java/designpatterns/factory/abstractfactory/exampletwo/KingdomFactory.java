package designpatterns.factory.abstractfactory.exampletwo;

public interface KingdomFactory {

  Castle createCastle();

  King createKing();

  Army createArmy();

}
