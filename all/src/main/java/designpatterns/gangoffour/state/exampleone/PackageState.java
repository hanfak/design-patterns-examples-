package designpatterns.gangoffour.state.exampleone;

public interface PackageState {

  void next(Package pkg);

  void prev(Package pkg);

  void printStatus();
}
