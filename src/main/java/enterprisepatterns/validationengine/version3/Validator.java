package enterprisepatterns.validationengine.version3;

@FunctionalInterface
public interface Validator<S> {
  S validate(S input);
}
