package enterprisepatterns.rulesengine.versiontwo.api;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    private final List<Rule> rules = new ArrayList<>();
    private final Facts facts;

    public BusinessRuleEngine(Facts facts) {
        this.facts = facts;
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void run() {
        this.rules.forEach(rule -> rule.perform(facts));
    }

    public List<Rule> getRules() {
        return rules;
    }
}
