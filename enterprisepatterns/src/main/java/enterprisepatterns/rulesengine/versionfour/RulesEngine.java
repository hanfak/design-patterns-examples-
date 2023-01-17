package enterprisepatterns.rulesengine.versionfour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class RulesEngine {

    private final Map<String, Rule> rules;

    public RulesEngine() {
        this.rules = new HashMap<>();
    }

    public void addRule(Rule rule) {
        rules.put(rule.getName(), rule);
    }

    public boolean evaluate(Object input) throws Exception {
        for (Rule rule : rules.values()) {
            if (rule.isEnabled()) { // only apply rule if flag is set
                boolean isRuleValid = true;
                List<String> dependencies = rule.getDependencies();
                if (dependencies != null && !dependencies.isEmpty()) { // where certain rules need to be evaluated before others.
                    for (String dep : dependencies) {
                        if (!rules.get(dep).isRuleValid()) {
                            isRuleValid = false;
                            break;
                        }
                    }
                }
                if (isRuleValid) {
                    isRuleValid = rule.getPredicate().test(input);
                }
                rule.setIsRuleValid(isRuleValid);
                if (!isRuleValid) {
                    if (rule.getException() != null) {
                        throw rule.getException();
                    } else {
                        return false;
                    }
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
    private List<String> dependencies;
    private boolean isRuleValid;

    public Rule(String name, Predicate<Object> predicate, boolean isEnabled, Exception exception, List<String> dependencies) {
        this.name = name;
        this.predicate = predicate;
        this.isEnabled = isEnabled;
        this.exception = exception;
        this.dependencies = dependencies;
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

    public List<String> getDependencies() {
        return dependencies;
    }

    public boolean isRuleValid() {
        return isRuleValid;
    }

    public void setIsRuleValid(boolean ruleValid) {
        isRuleValid = ruleValid;
    }
}

