package rulesengine.versionone;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

// Abstract ruler runner
public class RuleRunner<T, S> {
  private final List<Rule<T, S>> rules;

  public RuleRunner(Rule<T, S>... rules) {
    this(asList(rules));
  }

  public RuleRunner(List<Rule<T, S>> rules) {
    this.rules = rules;
  }

  // To use a builder
  public RuleRunner() {
    this.rules = new ArrayList<>();
  }

  // This will take a type T and return a type S, can return void and thus either mutate type T when rule is applied

  public S runRules(T entity) {
//    for (Rule<T, S> rule : rules) {
//        if (rule.matches(entity)) {
//          return rule.process(entity);
//        }
//    }
//    throw new RuntimeException("No Matching rule found");

    return rules.stream()
            .filter(rule -> rule.matches(entity))
            .map(rule -> rule.process(entity))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No Matching rule found"));
  }

  public RuleRunner<T, S> registerRule(Rule<T, S> rule) {
    rules.add(rule);
    return this;
  }
}