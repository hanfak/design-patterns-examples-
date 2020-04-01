package designpatterns.mediator.exampletwo;

public interface Mediator {
  void send(String message, Colleague colleague);
}
