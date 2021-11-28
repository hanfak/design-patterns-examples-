package refactoring.caseswitchrefactor.example3._04abstractfactory.enduranceplayer;

import refactoring.caseswitchrefactor.example3.old.Type;

public interface AbstractPlayerFactory {

  Player createPlayer(Type type, int delta);

}
