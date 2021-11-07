package refactoring.caseswitchrefactor.example3._04state;
//a simple interface meant to define a contract for our states (actions), register and unregister:
public interface PlayerState {

  void register();
  void unregister();
}
