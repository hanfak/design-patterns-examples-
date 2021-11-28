package refactoring.caseswitchrefactor.example5.rulesengine;

public interface Rule {
  boolean matches(Operator expression);
  Result evaluate(Expression expression);
}
