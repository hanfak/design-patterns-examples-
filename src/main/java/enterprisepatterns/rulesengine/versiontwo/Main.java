package enterprisepatterns.rulesengine.versiontwo;

import enterprisepatterns.rulesengine.versiontwo.api.BusinessRuleEngine;
import enterprisepatterns.rulesengine.versiontwo.api.Facts;
import enterprisepatterns.rulesengine.versiontwo.api.Rule;

import static enterprisepatterns.rulesengine.versiontwo.api.Name.ruleName;
import static enterprisepatterns.rulesengine.versiontwo.api.RuleBuilder.forARule;
import static enterprisepatterns.rulesengine.versiontwo.api.RuleBuilder.forARuleWithName;

public class Main {
  // TODO: run rules with different priorities, instead of order rule was added
  // TODO: read all facts from json file
  public static void main(final String... args) {

    var env = new Facts();
    env.setFact("name", "Bob");
    env.setFact("jobTitle", "CEO");
//    env.setFactsFromFile("src/main/resources/facts.json");

    final var businessRuleEngine = new BusinessRuleEngine(env);

    final Rule ruleSendEmailToSalesWhenCEOAndCalledBob =
            forARuleWithName(ruleName("ruleSendEmailToSalesWhenCEOAndCalledBob"))
                    .whenItMeetsCondition(facts -> "CEO".equals(facts.getFact("jobTitle")))
                    .andWhenItMeetsCondition(facts -> "Bob".equals(facts.getFact("name")))
                    .thenTheActionIsTaken(Main::printName);

    final Rule ruleSendEmailToSalesWhenCalledBob =
            forARule()
                    .withName(ruleName("ruleSendEmailToSalesWhenCalledBob"))
                    .andWhenItMeetsCondition(facts -> "Bob".equals(facts.getFact("name")))
                    .thenTheActionIsTaken(Main::printNameInUppercase);

    businessRuleEngine.addRule(ruleSendEmailToSalesWhenCEOAndCalledBob);
    businessRuleEngine.addRule(ruleSendEmailToSalesWhenCalledBob);
    businessRuleEngine.run();

    businessRuleEngine.getRules()
            .forEach(rule -> System.out.println(rule.getName()));

  }

  private static void printNameInUppercase(Facts facts) {
    var name = facts.getFact("name");
    System.out.println("Relevant customer!!!: " + name.toUpperCase());
  }

  private static void printName(Facts facts) {
    var name = facts.getFact("name");
    System.out.println("Relevant customer!!!: " + name);
  }
}
