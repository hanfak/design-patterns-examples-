package enterprisepatterns.rulesengine.versionsix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class RulesEngine {
    private final Map<String, List<Rule>> ruleGroups;

    public RulesEngine() {
        this.ruleGroups = new HashMap<>();
    }

    // Using groups of rules, to evaluate a set of rules for some input
    public void addRule(Rule rule, String groupName) {
        if (!ruleGroups.containsKey(groupName)) {
            ruleGroups.put(groupName, new ArrayList<>());
        }
        ruleGroups.get(groupName).add(rule);
    }

    public boolean evaluate(String groupName, Object input) throws Exception {
        if(!ruleGroups.containsKey(groupName))
            throw new IllegalArgumentException("Invalid Group Name");
        for(Rule rule: ruleGroups.get(groupName)) {
            if(rule.isEnabled()){
                boolean isRuleValid = rule.getPredicate().test(input);
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
    private Predicate<Object> predicate;
    private boolean isEnabled;
    private Exception exception;
    public Rule(Predicate<Object> predicate, boolean isEnabled, Exception exception) {
        this.predicate = predicate;
        this.isEnabled = isEnabled;
        this.exception = exception;
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


}