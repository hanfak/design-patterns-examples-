package enterprisepatterns.rulesengine.versionseven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
// Chaining rules -- todo
// can use a builder pattern
public class RulesEngine {
    private final Map<String, Rule> rules;

    public RulesEngine() {
        this.rules = new HashMap<>();
    }

    public void addRule(Rule rule) {
        rules.put(rule.getName(), rule);
    }

    public boolean evaluate(Object input) throws Exception {
        for(Rule rule: rules.values()) {
            if(rule.isEnabled()){
                boolean isRuleValid = rule.getPredicate().test(input);
                rule.setIsRuleValid(isRuleValid);
                if(!isRuleValid){
                    String nextRule = rule.getNextRule();
                    if(nextRule != null && rules.containsKey(nextRule)){
                        rule = rules.get(nextRule);
                    }
                    else if(rule.getException() != null)
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
    private boolean isEnabled;
    private Exception exception;
    private String nextRule;
    private boolean isRuleValid;
    public Rule(String name, Predicate<Object> predicate, boolean isEnabled, Exception exception, String nextRule) {
        this.name = name;
        this.predicate = predicate;
        this.isEnabled = isEnabled;
        this.exception = exception;
        this.nextRule = nextRule;
    }

    public String getName() {
        return name;
    }

    public Predicate<Object> getPredicate() {
        return predicate;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public Exception getException() {
        return exception;
    }

    public String getNextRule() {
        return nextRule;
    }

    public boolean isRuleValid() {
        return isRuleValid;
    }

    public void setIsRuleValid(boolean ruleValid) {
        isRuleValid = ruleValid;
    }
}