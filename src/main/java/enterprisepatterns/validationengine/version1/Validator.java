package enterprisepatterns.validationengine.version1;

@FunctionalInterface
public interface Validator<S> {
  S validate(S input);
}
