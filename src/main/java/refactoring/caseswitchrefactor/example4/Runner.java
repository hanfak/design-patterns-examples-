package refactoring.caseswitchrefactor.example4;

import refactoring.caseswitchrefactor.example4.better._01BetterUseCase;
import refactoring.caseswitchrefactor.example4.better._02BetterUseCase;
import refactoring.caseswitchrefactor.example4.better._03BetterUseCase;
import refactoring.caseswitchrefactor.example4.better._04BetterUseCase;
import refactoring.caseswitchrefactor.example4.old.OldUseCase;

public class Runner {
  public static void main(String[] args) {
    OldUseCase oldUseCase = new OldUseCase();
    oldUseCase.execute("cheese is good");
    System.out.println();

    _01BetterUseCase a01BetterUseCase = new _01BetterUseCase();
    a01BetterUseCase.execute("bar is bar");

    System.out.println();
    _02BetterUseCase a02BetterUseCase = new _02BetterUseCase();
    a02BetterUseCase.execute("foo is bar");

    System.out.println();
    _03BetterUseCase a03BetterUseCase = new _03BetterUseCase();
    a03BetterUseCase.execute("foo is bar");

    System.out.println();
    _04BetterUseCase a04BetterUseCase = new _04BetterUseCase();
    a04BetterUseCase.execute("foo is bar");
  }
}
