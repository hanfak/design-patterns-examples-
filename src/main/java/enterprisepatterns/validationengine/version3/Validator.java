package enterprisepatterns.validationengine.version3;

import java.util.List;

@FunctionalInterface
public interface Validator<S> {
  List<S> validate(List<S> inputs); // TODO what generic ? extends S or ? super S
}
