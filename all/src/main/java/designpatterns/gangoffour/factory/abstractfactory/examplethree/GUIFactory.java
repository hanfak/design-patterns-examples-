package designpatterns.gangoffour.factory.abstractfactory.examplethree;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
  Button createButton();
  Checkbox createCheckbox();
}
