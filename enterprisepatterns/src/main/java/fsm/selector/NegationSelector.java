package fsm.selector;


/**
 * A Selector defined as the negation (NOT) of a (leaf) selectors. This is of course only useful
 * when used in combination with other composite selectors.
 */
public class NegationSelector<T> extends AbstractSelector<T> {

  private AbstractSelector<T> component;

  NegationSelector(AbstractSelector<T> selector) {
    this.component = selector;
  }

  @Override
  public boolean test(T t) {
    return !(component.test(t));
  }
}
