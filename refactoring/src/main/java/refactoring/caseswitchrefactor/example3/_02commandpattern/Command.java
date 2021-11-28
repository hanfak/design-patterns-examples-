package refactoring.caseswitchrefactor.example3._02commandpattern;

import refactoring.caseswitchrefactor.example3.players.Player;

public interface Command {

  Player create();
}