package enterprisepatterns.validationengine.version2;

@FunctionalInterface
public interface Validator<S> {
  S validate(S input);
}
