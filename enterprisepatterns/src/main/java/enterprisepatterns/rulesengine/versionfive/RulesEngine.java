package enterprisepatterns.rulesengine.versionfive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class RulesEngine {
    private final Map<String, Rule> rules;

    public RulesEngine() {
        this.rules = new HashMap<>();
    }

    public void addRule(Rule rule) {
        rules.put(rule.getName(), rule);
    }

    public boolean evaluate(Object input) throws Exception {
        // order rules before starting to apply them
        List<Rule> sortedRules = rules.values().stream()
                .sorted(comparingInt(Rule::getPriority))
                .collect(toList());
        for(Rule rule: sortedRules) {
            if(rule.isEnabled()){
                boolean isRuleValid = rule.getPredicate().test(input);
                rule.setIsRuleValid(isRuleValid);
                if(!isRuleValid){
                    if(rule.getException() != null)
                        throw rule.getException();
                    else
                        return false;
                }
            }
        }
        return true;
    }
}

class Rule {
    private String name;
    private Predicate<Object> predicate;
    private int priority;
    private boolean isEnabled;
    private Exception exception;
    private boolean isRuleValid;
    public Rule(String name, Predicate<Object> predicate, int priority, boolean isEnabled, Exception exception) {
        this.name = name;
        this.predicate = predicate;
        this.priority = priority;
        this.isEnabled = isEnabled;
        this.exception = exception;
    }

    public String getName() {
        return name;
    }

    public Predicate<Object> getPredicate() {
        return predicate;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public Exception getException() {
        return exception;
    }

    public boolean isRuleValid() {
        return isRuleValid;
    }

    public void setIsRuleValid(boolean ruleValid) {
        isRuleValid = ruleValid;
    }
}